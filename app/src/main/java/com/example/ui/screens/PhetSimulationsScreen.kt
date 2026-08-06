package com.example.ui.screens

import android.content.Intent
import android.net.Uri
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.example.model.ExamType
import com.example.ui.theme.*
import com.example.ui.viewmodel.MainViewModel
import com.example.ui.viewmodel.Screen

data class PhetSimulationItem(
    val id: String,
    val title: String,
    val subject: String, // "Physics", "Chemistry", "Biology", "Math"
    val examTopic: String,
    val description: String,
    val phetUrl: String,
    val iconEmoji: String,
    val color: Color,
    val imageUrl: String? = null
)

const val OFFICIAL_PHET_LOGO_URL = "https://phet.colorado.edu/images/phet-logo-trademarked.png"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhetSimulationsScreen(viewModel: MainViewModel) {
    val selectedExam by viewModel.selectedExam.collectAsState()
    val context = LocalContext.current

    var selectedCategory by remember { mutableStateOf("All") }
    var searchQuery by remember { mutableStateOf("") }
    var shuffleCounter by remember { mutableStateOf(0) }
    var activeSimForWebView by remember { mutableStateOf<PhetSimulationItem?>(null) }
    var pendingSimToLaunch by remember { mutableStateOf<PhetSimulationItem?>(null) }

    val allPhetSimulations = remember {
        listOf(
            // 1. Generator
            PhetSimulationItem(
                id = "generator_induction",
                title = "Generator & Electromagnetic Induction",
                subject = "Physics",
                examTopic = "Faraday's Law & AC Generators",
                description = "Turn a water faucet to rotate a magnet and generate electricity in a coil to light up a bulb.",
                phetUrl = "https://phet.colorado.edu/sims/html/generator/latest/generator_all.html",
                iconEmoji = "⚙️",
                color = Color(0xFFF59E0B)
            ),
            // 2. Projectile Motion
            PhetSimulationItem(
                id = "projectile_motion",
                title = "Projectile Motion Cannon",
                subject = "Physics",
                examTopic = "Kinematics 2D & Motion under Gravity",
                description = "Fire cannonballs at different angles and velocities. Adjust air resistance, mass, and drag coefficient.",
                phetUrl = "https://phet.colorado.edu/sims/html/projectile-motion/latest/projectile-motion_all.html",
                iconEmoji = "🎯",
                color = Color(0xFFEF4444)
            ),
            // 3. Energy Skate Park
            PhetSimulationItem(
                id = "energy_skate_park",
                title = "Energy Skate Park",
                subject = "Physics",
                examTopic = "Work, Energy & Conservation of Energy",
                description = "Track kinetic, potential, and thermal energy of a skater on custom tracks with friction controls.",
                phetUrl = "https://phet.colorado.edu/sims/html/energy-skate-park/latest/energy-skate-park_all.html",
                iconEmoji = "🛹",
                color = Color(0xFF14B8A6)
            ),
            // 4. Masses and Springs
            PhetSimulationItem(
                id = "masses_and_springs",
                title = "Masses and Springs Lab",
                subject = "Physics",
                examTopic = "Simple Harmonic Motion & Hooke's Law",
                description = "Hang masses on springs and adjust stiffness, damping, and gravity to measure period and oscillation energy.",
                phetUrl = "https://phet.colorado.edu/sims/html/masses-and-springs/latest/masses-and-springs_all.html",
                iconEmoji = "🌀",
                color = Color(0xFF8B5CF6)
            ),
            // 5. Pendulum Lab
            PhetSimulationItem(
                id = "pendulum_lab",
                title = "Pendulum Lab",
                subject = "Physics",
                examTopic = "Simple Pendulum & Oscillations",
                description = "Play with single or double pendulums and adjust length, mass, gravity, and friction to observe period and energy.",
                phetUrl = "https://phet.colorado.edu/sims/html/pendulum-lab/latest/pendulum-lab_all.html",
                iconEmoji = "⏱️",
                color = Color(0xFF6366F1)
            ),
            // 6. Wave on a String
            PhetSimulationItem(
                id = "wave_string",
                title = "Wave on a String",
                subject = "Physics",
                examTopic = "Transverse Waves & Standing Waves",
                description = "Wiggle the end of a string and observe wave propagation, damping, tension, and boundary reflection.",
                phetUrl = "https://phet.colorado.edu/sims/html/wave-on-a-string/latest/wave-on-a-string_all.html",
                iconEmoji = "🪀",
                color = Color(0xFF14B8A6)
            ),
            // 7. Sound
            PhetSimulationItem(
                id = "sound_waves",
                title = "Sound Waves & Interference",
                subject = "Physics",
                examTopic = "Acoustics & Compression Waves",
                description = "Simulate sound waves, pitch, frequency, and acoustic pressure waves from a speaker.",
                phetUrl = "https://phet.colorado.edu/sims/html/sound/latest/sound_all.html",
                iconEmoji = "🔊",
                color = Color(0xFF0284C7)
            ),
            // 8. Geometric Optics
            PhetSimulationItem(
                id = "geometric_optics",
                title = "Geometric Optics (Lenses & Mirrors)",
                subject = "Physics",
                examTopic = "Ray Optics & Image Formation",
                description = "Form real and virtual images using convex/concave lenses and spherical mirrors with ray diagrams.",
                phetUrl = "https://phet.colorado.edu/sims/html/geometric-optics/latest/geometric-optics_all.html",
                iconEmoji = "🔍",
                color = Color(0xFFEC4899)
            ),
            // 9. Bending Light
            PhetSimulationItem(
                id = "bending_light",
                title = "Bending Light (Refraction & Prisms)",
                subject = "Physics",
                examTopic = "Ray Optics & Total Internal Reflection",
                description = "Explore Snell's law of refraction, critical angle, total internal reflection, and dispersion through prisms.",
                phetUrl = "https://phet.colorado.edu/sims/html/bending-light/latest/bending-light_all.html",
                iconEmoji = "🌈",
                color = Color(0xFFEC4899)
            ),
            // 10. Circuit Construction Kit (DC)
            PhetSimulationItem(
                id = "circuit_dc",
                title = "Circuit Construction Kit (DC)",
                subject = "Physics",
                examTopic = "Current Electricity & Resistance",
                description = "Build circuits with resistors, light bulbs, batteries, and switches. Measure current and voltage with ammeters and voltmeters.",
                phetUrl = "https://phet.colorado.edu/sims/html/circuit-construction-kit-dc/latest/circuit-construction-kit-dc_all.html",
                iconEmoji = "⚡",
                color = Color(0xFF38BDF8)
            ),
            // 11. Ohm's Law
            PhetSimulationItem(
                id = "ohms_law",
                title = "Ohm's Law Interactive",
                subject = "Physics",
                examTopic = "Current Electricity V = IR",
                description = "Change current and resistance to see how voltage dynamically changes according to Ohm's Law.",
                phetUrl = "https://phet.colorado.edu/sims/html/ohms-law/latest/ohms-law_all.html",
                iconEmoji = "💡",
                color = Color(0xFFF97316)
            ),
            // 12. Resistance in a Wire
            PhetSimulationItem(
                id = "resistance_in_a_wire",
                title = "Resistance in a Wire (R = ρL/A)",
                subject = "Physics",
                examTopic = "Resistivity, Length & Area Dependency",
                description = "Adjust resistivity, wire length, and area to see how total electrical resistance changes in real time.",
                phetUrl = "https://phet.colorado.edu/sims/html/resistance-in-a-wire/latest/resistance-in-a-wire_all.html",
                iconEmoji = "🔌",
                color = Color(0xFF10B981)
            ),
            // 13. Capacitor Lab
            PhetSimulationItem(
                id = "capacitor_lab_basics",
                title = "Capacitor Lab: Basics (C = εA/d)",
                subject = "Physics",
                examTopic = "Capacitance, Dielectrics & Stored Charge",
                description = "Change plate area and separation distance to observe capacitance, stored electrical energy, and electric field.",
                phetUrl = "https://phet.colorado.edu/sims/html/capacitor-lab-basics/latest/capacitor-lab-basics_all.html",
                iconEmoji = "🔋",
                color = Color(0xFF06B6D4)
            ),
            // 14. Charges and Fields
            PhetSimulationItem(
                id = "charges_fields",
                title = "Charges & Electric Fields",
                subject = "Physics",
                examTopic = "Electrostatics & Field Intensity",
                description = "Place positive and negative charges in space and view the electric field lines, equipotential surfaces, and electrostatic forces.",
                phetUrl = "https://phet.colorado.edu/sims/html/charges-and-fields/latest/charges-and-fields_all.html",
                iconEmoji = "⚛️",
                color = Color(0xFF0284C7)
            ),
            // 15. Magnets and Electromagnets
            PhetSimulationItem(
                id = "magnet_and_compass",
                title = "Magnets & Compass Field",
                subject = "Physics",
                examTopic = "Magnetism & Magnetic Field Lines",
                description = "Move a compass around a bar magnet to observe magnetic field vectors and Earth's magnetic pole alignment.",
                phetUrl = "https://phet.colorado.edu/sims/html/magnet-and-compass/latest/magnet-and-compass_all.html",
                iconEmoji = "🧲",
                color = Color(0xFF3B82F6)
            ),

            // ==================== CHEMISTRY MUST HAVES (TOP 10) ====================
            // 1. Build an Atom
            PhetSimulationItem(
                id = "build_atom",
                title = "Build an Atom & Isotopes",
                subject = "Chemistry",
                examTopic = "Atomic Structure & Subatomic Particles",
                description = "Build atoms with protons, neutrons, and electrons. View atomic number, mass number, and electronic shell configurations.",
                phetUrl = "https://phet.colorado.edu/sims/html/build-an-atom/latest/build-an-atom_all.html",
                iconEmoji = "🔮",
                color = Color(0xFF8B5CF6)
            ),
            // 2. Molecule Shapes (VSEPR)
            PhetSimulationItem(
                id = "molecule_shapes",
                title = "Molecule Shapes 3D (VSEPR)",
                subject = "Chemistry",
                examTopic = "Chemical Bonding & VSEPR Theory",
                description = "Explore 3D molecular geometries, bond angles, and electron lone pairs interactively according to VSEPR theory.",
                phetUrl = "https://phet.colorado.edu/sims/html/molecule-shapes/latest/molecule-shapes_all.html",
                iconEmoji = "🧪",
                color = Color(0xFFA855F7)
            ),
            // 3. Molecule Polarity
            PhetSimulationItem(
                id = "molecule_polarity",
                title = "Molecule Polarity & Dipole Moments",
                subject = "Chemistry",
                examTopic = "Chemical Bonding & Electronegativity",
                description = "Change atom electronegativities to see how bond polarity, dipole moments, and partial charges affect molecular behavior in electric fields.",
                phetUrl = "https://phet.colorado.edu/sims/html/molecule-polarity/latest/molecule-polarity_all.html",
                iconEmoji = "⚡",
                color = Color(0xFFEC4899)
            ),
            // 4. Balancing Chemical Equations
            PhetSimulationItem(
                id = "balancing_chemical_equations",
                title = "Balancing Chemical Equations",
                subject = "Chemistry",
                examTopic = "Stoichiometry & Chemical Reactions",
                description = "Balance reactants and products in synthesis, decomposition, and combustion reactions using visual balance scales.",
                phetUrl = "https://phet.colorado.edu/sims/html/balancing-chemical-equations/latest/balancing-chemical-equations_all.html",
                iconEmoji = "⚖️",
                color = Color(0xFF10B981)
            ),
            // 5. Concentration
            PhetSimulationItem(
                id = "concentration_chem",
                title = "Concentration & Solutes",
                subject = "Chemistry",
                examTopic = "Solutions & Saturation",
                description = "Add solid and liquid solutes to water, measure concentration with a meter, and observe saturation limits.",
                phetUrl = "https://phet.colorado.edu/sims/html/concentration/latest/concentration_all.html",
                iconEmoji = "🧪",
                color = Color(0xFF06B6D4)
            ),
            // 6. Molarity
            PhetSimulationItem(
                id = "molarity_chem",
                title = "Molarity (M = moles / Liter)",
                subject = "Chemistry",
                examTopic = "Solutions & Concentration Terms",
                description = "Dissolve solutes in water and adjust volume to see how molarity changes dynamically with color depth indicator.",
                phetUrl = "https://phet.colorado.edu/sims/html/molarity/latest/molarity_all.html",
                iconEmoji = "🍷",
                color = Color(0xFF0284C7)
            ),
            // 7. pH Scale
            PhetSimulationItem(
                id = "ph_scale",
                title = "pH Scale & Hydronium Ions",
                subject = "Chemistry",
                examTopic = "Ionic Equilibrium & Acids/Bases",
                description = "Test pH of common liquids, dilute with water, and monitor H3O+ / OH- logarithmic ion concentrations.",
                phetUrl = "https://phet.colorado.edu/sims/html/ph-scale/latest/ph-scale_all.html",
                iconEmoji = "💧",
                color = Color(0xFF10B981)
            ),
            // 8. Acid-Base Solutions
            PhetSimulationItem(
                id = "acid_base",
                title = "Acid-Base Solutions Lab",
                subject = "Chemistry",
                examTopic = "Equilibrium & Electrical Conductivity",
                description = "Compare strong vs weak acids and bases. Insert light bulb electrodes to measure solution electrical conductivity.",
                phetUrl = "https://phet.colorado.edu/sims/html/acid-base-solutions/latest/acid-base-solutions_all.html",
                iconEmoji = "⚗️",
                color = Color(0xFF8B5CF6)
            ),
            // 9. Gas Properties
            PhetSimulationItem(
                id = "gas_properties",
                title = "Gas Properties & Ideal Gas Law",
                subject = "Chemistry",
                examTopic = "States of Matter & Gas Laws (PV = nRT)",
                description = "Pump heavy and light gas molecules into a box. Adjust volume, temperature, and pressure to observe gas law behavior.",
                phetUrl = "https://phet.colorado.edu/sims/html/gas-properties/latest/gas-properties_all.html",
                iconEmoji = "🔥",
                color = Color(0xFFEF4444)
            ),
            // 10. States of Matter
            PhetSimulationItem(
                id = "states_of_matter",
                title = "States of Matter & Phase Changes",
                subject = "Chemistry",
                examTopic = "Thermodynamics & Intermolecular Forces",
                description = "Heat, cool, and compress atoms/molecules to observe solid, liquid, and gas phases and phase transition curves.",
                phetUrl = "https://phet.colorado.edu/sims/html/states-of-matter/latest/states-of-matter_all.html",
                iconEmoji = "🧊",
                color = Color(0xFF38BDF8)
            ),

            // ==================== MATHEMATICS MUST HAVES (TOP 7) ====================
            // 1. Graphing Quadratics
            PhetSimulationItem(
                id = "graphing_quadratics",
                title = "Graphing Quadratics (y = ax² + bx + c)",
                subject = "Math",
                examTopic = "Algebra & Quadratic Equations",
                description = "Explore parabolic graphs by varying coefficients a, b, and c in standard, vertex, and factored forms.",
                phetUrl = "https://phet.colorado.edu/sims/html/graphing-quadratics/latest/graphing-quadratics_all.html",
                iconEmoji = "📈",
                color = Color(0xFF3B82F6)
            ),
            // 2. Graphing Lines
            PhetSimulationItem(
                id = "graphing_lines",
                title = "Graphing Lines (y = mx + b)",
                subject = "Math",
                examTopic = "Coordinate Geometry & Linear Equations",
                description = "Investigate slope, y-intercept, x-intercept, and line equations interactively on a 2D Cartesian plane.",
                phetUrl = "https://phet.colorado.edu/sims/html/graphing-lines/latest/graphing-lines_all.html",
                iconEmoji = "📉",
                color = Color(0xFF10B981)
            ),
            // 3. Function Builder
            PhetSimulationItem(
                id = "function_builder",
                title = "Function Builder & Machine",
                subject = "Math",
                examTopic = "Algebra & Functions Mapping",
                description = "Build mathematical functions with input-output machines, visual function tables, and graphical representations.",
                phetUrl = "https://phet.colorado.edu/sims/html/function-builder/latest/function-builder_all.html",
                iconEmoji = "🧮",
                color = Color(0xFF8B5CF6)
            ),
            // 4. Curve Fitting
            PhetSimulationItem(
                id = "curve_fitting",
                title = "Curve Fitting & Regression",
                subject = "Math",
                examTopic = "Statistics, Least Squares & Data Analysis",
                description = "Drag data points and fit linear, quadratic, cubic, or exponential curves with real-time error residuals.",
                phetUrl = "https://phet.colorado.edu/sims/html/curve-fitting/latest/curve-fitting_all.html",
                iconEmoji = "📊",
                color = Color(0xFFF59E0B)
            ),
            // 5. Plinko Probability
            PhetSimulationItem(
                id = "plinko_probability",
                title = "Plinko Probability & Normal Distribution",
                subject = "Math",
                examTopic = "Probability & Binomial Distribution",
                description = "Drop balls through a peg board to discover binomial probability distributions, mean, and standard deviation.",
                phetUrl = "https://phet.colorado.edu/sims/html/plinko-probability/latest/plinko-probability_all.html",
                iconEmoji = "🎲",
                color = Color(0xFFEC4899)
            ),
            // 6. Mean: Share and Balance
            PhetSimulationItem(
                id = "mean_share_and_balance",
                title = "Mean: Share and Balance",
                subject = "Math",
                examTopic = "Statistics & Central Tendency",
                description = "Explore arithmetic mean, median, mode, and balance point concepts using interactive leveling bars and data sets.",
                phetUrl = "https://phet.colorado.edu/sims/html/mean-share-and-balance/latest/mean-share-and-balance_all.html",
                iconEmoji = "⚖️",
                color = Color(0xFF06B6D4)
            ),
            // 7. Area Builder
            PhetSimulationItem(
                id = "area_builder",
                title = "Area Builder & Perimeter",
                subject = "Math",
                examTopic = "Geometry & Mensuration",
                description = "Build custom shapes on a grid to learn relationships between area, perimeter, fractional parts, and symmetry.",
                phetUrl = "https://phet.colorado.edu/sims/html/area-builder/latest/area-builder_all.html",
                iconEmoji = "📐",
                color = Color(0xFF84CC16)
            ),

            // ==================== BIOLOGY MUST HAVES (TOP 10) ====================
            // 1. Natural Selection
            PhetSimulationItem(
                id = "natural_selection",
                title = "Natural Selection & Evolution",
                subject = "Biology",
                examTopic = "Genetics, Mutations & Survival",
                description = "Explore how mutations (fur color, tooth length) affect bunny population survival in arctic and equator biomes.",
                phetUrl = "https://phet.colorado.edu/sims/html/natural-selection/latest/natural-selection_all.html",
                iconEmoji = "🐰",
                color = Color(0xFF10B981)
            ),
            // 2. Gene Expression Essentials
            PhetSimulationItem(
                id = "gene_expression",
                title = "Gene Expression Essentials",
                subject = "Biology",
                examTopic = "Molecular Basis of Inheritance & Transcription",
                description = "Express genes by creating mRNA and proteins. Regulate transcription with promoters and transcription factors.",
                phetUrl = "https://phet.colorado.edu/sims/html/gene-expression-essentials/latest/gene-expression-essentials_all.html",
                iconEmoji = "🧬",
                color = Color(0xFF84CC16)
            ),
            // 3. Gene Machine: The Lac Operon
            PhetSimulationItem(
                id = "lac_operon",
                title = "Gene Machine: The Lac Operon",
                subject = "Biology",
                examTopic = "Gene Regulation & Operon Concept",
                description = "Explore how lac operon genes are turned on or off in E. coli response to lactose and glucose concentrations.",
                phetUrl = "https://phet.colorado.edu/sims/html/gene-machine-lac-operon/latest/gene-machine-lac-operon_all.html",
                iconEmoji = "⚙️",
                color = Color(0xFF06B6D4)
            ),
            // 4. Membrane Channels
            PhetSimulationItem(
                id = "membrane_channels",
                title = "Membrane Channels & Transport",
                subject = "Biology",
                examTopic = "Cell Membrane & Transport Dynamics",
                description = "Observe how water, ions, and molecules pass through gated and leak channels in cell membranes.",
                phetUrl = "https://phet.colorado.edu/sims/html/membrane-channels/latest/membrane-channels_all.html",
                iconEmoji = "🧼",
                color = Color(0xFF3B82F6)
            ),
            // 5. Neuron
            PhetSimulationItem(
                id = "neuron_sim",
                title = "Neuron & Action Potential",
                subject = "Biology",
                examTopic = "Neural Control & Signal Transmission",
                description = "Stimulate a neuron to observe action potentials, sodium/potassium ion channels, and nerve impulses.",
                phetUrl = "https://phet.colorado.edu/sims/html/neuron/latest/neuron_all.html",
                iconEmoji = "🧠",
                color = Color(0xFFEC4899)
            ),
            // 6. Diffusion
            PhetSimulationItem(
                id = "diffusion_bio",
                title = "Diffusion & Concentration Gradient",
                subject = "Biology",
                examTopic = "Cell Biology & Passive Transport",
                description = "Watch gas particles diffuse across a membrane until dynamic equilibrium is reached.",
                phetUrl = "https://phet.colorado.edu/sims/html/diffusion/latest/diffusion_all.html",
                iconEmoji = "💨",
                color = Color(0xFF14B8A6)
            ),
            // 7. Molecule Polarity
            PhetSimulationItem(
                id = "molecule_polarity_bio",
                title = "Molecule Polarity & Biological Membranes",
                subject = "Biology",
                examTopic = "Biomolecules & Membrane Permeability",
                description = "See how polarity and electronegativity determine whether molecules can dissolve or pass through lipid bilayers.",
                phetUrl = "https://phet.colorado.edu/sims/html/molecule-polarity/latest/molecule-polarity_all.html",
                iconEmoji = "💧",
                color = Color(0xFF8B5CF6)
            ),
            // 8. Osmosis
            PhetSimulationItem(
                id = "osmosis_transport",
                title = "Osmosis & Cell Membrane Transport",
                subject = "Biology",
                examTopic = "Tonicity & Water Potential",
                description = "Investigate water diffusion across semi-permeable membranes under hypertonic, hypotonic, and isotonic states.",
                phetUrl = "https://phet.colorado.edu/sims/html/diffusion/latest/diffusion_all.html",
                iconEmoji = "🌊",
                color = Color(0xFF0284C7)
            ),
            // 9. DNA Replication & Structure
            PhetSimulationItem(
                id = "build_dna",
                title = "Build a DNA Molecule & Expression",
                subject = "Biology",
                examTopic = "DNA Structure & Replication",
                description = "Pair nitrogenous bases (A-T, C-G) to build double helix DNA strands and explore transcription rules.",
                phetUrl = "https://phet.colorado.edu/sims/html/gene-expression-essentials/latest/gene-expression-essentials_all.html",
                iconEmoji = "🔬",
                color = Color(0xFFF59E0B)
            ),
            // 10. Protein Synthesis
            PhetSimulationItem(
                id = "protein_synthesis_sim",
                title = "Protein Synthesis & Ribosomes",
                subject = "Biology",
                examTopic = "Translation & Amino Acid Chains",
                description = "Translate mRNA sequences into polypeptide chains with tRNA and ribosomes in real-time molecular view.",
                phetUrl = "https://phet.colorado.edu/sims/html/gene-expression-essentials/latest/gene-expression-essentials_all.html",
                iconEmoji = "🧬",
                color = Color(0xFF10B981)
            ),

            // Additional Popular Sims (Physics, Math)
            PhetSimulationItem(
                id = "gravity_orbits",
                title = "Gravity & Orbits (Kepler's Laws)",
                subject = "Physics",
                examTopic = "Gravitation & Satellite Motion",
                description = "Move the sun, earth, moon and space station to see how gravitational attraction and orbital speed change according to Kepler's Laws.",
                phetUrl = "https://phet.colorado.edu/sims/html/gravity-and-orbits/latest/gravity-and-orbits_all.html",
                iconEmoji = "🪐",
                color = Color(0xFF6366F1)
            ),
            PhetSimulationItem(
                id = "wave_interference",
                title = "Wave Interference Lab",
                subject = "Physics",
                examTopic = "Wave Optics & Diffraction",
                description = "Make waves with water, sound, and light. Observe Young's double slit interference, diffraction, and superposition.",
                phetUrl = "https://phet.colorado.edu/sims/html/wave-interference/latest/wave-interference_all.html",
                iconEmoji = "🌊",
                color = Color(0xFF06B6D4)
            ),
            PhetSimulationItem(
                id = "coulomb_law",
                title = "Coulomb's Law",
                subject = "Physics",
                examTopic = "Electrostatics Inverse Square Law",
                description = "Visualize electrostatic forces between two charged spheres as distance and charge magnitudes change.",
                phetUrl = "https://phet.colorado.edu/sims/html/coulombs-law/latest/coulombs-law_all.html",
                iconEmoji = "⚡",
                color = Color(0xFFA855F7)
            ),
            PhetSimulationItem(
                id = "vector_addition",
                title = "Vector Addition 2D",
                subject = "Math",
                examTopic = "Vectors, Components & Resultant",
                description = "Add vectors graphically in Cartesian and polar coordinates. Calculate vector dot product and magnitude.",
                phetUrl = "https://phet.colorado.edu/sims/html/vector-addition/latest/vector-addition_all.html",
                iconEmoji = "📐",
                color = Color(0xFFEC4899)
            ),
            PhetSimulationItem(
                id = "density_buoyancy",
                title = "Density & Buoyancy Lab",
                subject = "Physics",
                examTopic = "Fluid Mechanics & Archimedes' Principle",
                description = "Drop custom blocks into fluids to observe sinking, floating, and buoyant forces in real time.",
                phetUrl = "https://phet.colorado.edu/sims/html/density/latest/density_all.html",
                iconEmoji = "⚓",
                color = Color(0xFF0284C7)
            ),
            PhetSimulationItem(
                id = "trig_tour",
                title = "Trig Tour & Unit Circle",
                subject = "Math",
                examTopic = "Trigonometry & Sinusoidal Functions",
                description = "Rotate angles around the unit circle to visualize sine, cosine, tangent values, and radian angles.",
                phetUrl = "https://phet.colorado.edu/sims/html/trig-tour/latest/trig-tour_all.html",
                iconEmoji = "⭕",
                color = Color(0xFFE11D48)
            )
        )
    }

    val categories = listOf("All", "Physics", "Chemistry", "Biology", "Math")

    // Filter and Shuffle logic
    val filteredAndShuffledSims = remember(selectedCategory, searchQuery, shuffleCounter) {
        var result = if (selectedCategory == "All") {
            allPhetSimulations
        } else {
            allPhetSimulations.filter { it.subject.equals(selectedCategory, ignoreCase = true) }
        }

        if (searchQuery.isNotBlank()) {
            val query = searchQuery.trim().lowercase()
            result = result.filter {
                it.title.lowercase().contains(query) ||
                it.examTopic.lowercase().contains(query) ||
                it.description.lowercase().contains(query) ||
                it.subject.lowercase().contains(query)
            }
        }

        // Apply shuffle rotation if user clicks refresh
        if (shuffleCounter > 0) {
            val random = java.util.Random(shuffleCounter.toLong() * 997L)
            result.shuffled(random)
        } else {
            result
        }
    }

    val featuredSim = remember(shuffleCounter, selectedCategory) {
        val pool = if (selectedCategory == "All") allPhetSimulations else allPhetSimulations.filter { it.subject.equals(selectedCategory, ignoreCase = true) }
        pool.getOrElse(shuffleCounter % pool.size) { pool.first() }
    }

    Scaffold(
        contentWindowInsets = WindowInsets.statusBars,
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        // Official PhET Logo Image
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color.White,
                            border = BorderStroke(1.dp, Color(0xFF0284C7).copy(alpha = 0.3f)),
                            modifier = Modifier
                                .height(32.dp)
                                .widthIn(min = 60.dp)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            ) {
                                AsyncImage(
                                    model = OFFICIAL_PHET_LOGO_URL,
                                    contentDescription = "PhET Official Logo",
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier.fillMaxHeight()
                                )
                            }
                        }

                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(
                                    text = "PhET Interactive Sims",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp,
                                    color = BentoOnSurface
                                )
                                Surface(
                                    shape = RoundedCornerShape(12.dp),
                                    color = Color(0xFFE0F2FE),
                                    border = BorderStroke(1.dp, Color(0xFF0284C7).copy(alpha = 0.4f))
                                ) {
                                    Text(
                                        text = "${allPhetSimulations.size}+ LABS",
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color(0xFF0284C7),
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                            }
                            Text(
                                text = "University of Colorado Boulder",
                                fontSize = 10.5.sp,
                                color = BentoOnSurfaceVariant
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateToScreen(Screen.HOME) },
                        modifier = Modifier.testTag("phet_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = BentoOnSurface
                        )
                    }
                },
                actions = {
                    // Refresh Topics Button
                    IconButton(
                        onClick = {
                            shuffleCounter++
                            android.widget.Toast.makeText(context, "Refreshed topic recommendations! 🔀", android.widget.Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "Refresh Topics",
                            tint = Color(0xFF0284C7)
                        )
                    }

                    IconButton(
                        onClick = {
                            try {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://phet.colorado.edu"))
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                context.startActivity(intent)
                            } catch (e: Exception) {
                                android.widget.Toast.makeText(context, "Opening phet.colorado.edu", android.widget.Toast.LENGTH_SHORT).show()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Language,
                            contentDescription = "Official PhET Website",
                            tint = BentoPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BentoSurface)
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(BentoBackground)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Official Branding Banner & Featured Simulation Spotlight
                item {
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = Color(0xFF0F172A),
                        border = BorderStroke(1.dp, Color(0xFF0284C7).copy(alpha = 0.5f)),
                        shadowElevation = 3.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            // Top Branding Bar with Official Logo Image
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Surface(
                                    shape = RoundedCornerShape(10.dp),
                                    color = Color.White,
                                    modifier = Modifier.padding(2.dp)
                                ) {
                                    AsyncImage(
                                        model = OFFICIAL_PHET_LOGO_URL,
                                        contentDescription = "PhET Interactive Simulations Logo",
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier
                                            .height(36.dp)
                                            .padding(horizontal = 8.dp, vertical = 4.dp)
                                    )
                                }

                                Surface(
                                    shape = RoundedCornerShape(20.dp),
                                    color = Color(0xFF0284C7).copy(alpha = 0.2f),
                                    border = BorderStroke(1.dp, Color(0xFF0284C7))
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                                    ) {
                                        Text("✨", fontSize = 12.sp)
                                        Text(
                                            text = "CC-BY 4.0 Open Source",
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF38BDF8)
                                        )
                                    }
                                }
                            }

                            // Featured Simulation Spotlight
                            Surface(
                                onClick = { pendingSimToLaunch = featuredSim },
                                shape = RoundedCornerShape(16.dp),
                                color = Color(0xFF1E293B),
                                border = BorderStroke(1.dp, featuredSim.color.copy(alpha = 0.6f)),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(
                                    modifier = Modifier.padding(14.dp),
                                    verticalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Surface(
                                            shape = RoundedCornerShape(8.dp),
                                            color = featuredSim.color
                                        ) {
                                            Text(
                                                text = "🔥 FEATURED LAB OF THE DAY",
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.Black,
                                                color = Color.White,
                                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                            )
                                        }

                                        Text(
                                            text = "Tap to Launch 🚀",
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF38BDF8)
                                        )
                                    }

                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                                    ) {
                                        Text(featuredSim.iconEmoji, fontSize = 28.sp)
                                        Column {
                                            Text(
                                                text = featuredSim.title,
                                                fontSize = 15.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.White
                                            )
                                            Text(
                                                text = "${featuredSim.subject} • ${featuredSim.examTopic}",
                                                fontSize = 11.5.sp,
                                                color = featuredSim.color
                                            )
                                        }
                                    }
                                }
                            }

                            HorizontalDivider(color = Color(0xFF334155))

                            Text(
                                text = "Legal Attribution: PhET Interactive Simulations is a registered trademark of the Regents of the University of Colorado. Open-source HTML5 simulations available under Creative Commons Attribution 4.0 at https://phet.colorado.edu.",
                                fontSize = 9.5.sp,
                                color = Color(0xFF64748B),
                                lineHeight = 13.sp
                            )
                        }
                    }
                }

                // Search Bar & Refresh / Shuffle Bar
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        OutlinedTextField(
                            value = searchQuery,
                            onValueChange = { searchQuery = it },
                            placeholder = { Text("Search 25+ topics (e.g., Optics, Circuits, Gene, pH)...", fontSize = 12.5.sp) },
                            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = BentoPrimary) },
                            trailingIcon = {
                                if (searchQuery.isNotEmpty()) {
                                    IconButton(onClick = { searchQuery = "" }) {
                                        Icon(Icons.Default.Clear, contentDescription = "Clear", tint = BentoOnSurfaceVariant)
                                    }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("phet_search_input"),
                            shape = RoundedCornerShape(16.dp),
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = BentoSurface,
                                unfocusedContainerColor = BentoSurface,
                                focusedBorderColor = BentoPrimary,
                                unfocusedBorderColor = BentoSurfaceVariant
                            )
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Showing ${filteredAndShuffledSims.size} Simulations",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = BentoOnSurfaceVariant
                            )

                            Surface(
                                onClick = {
                                    shuffleCounter++
                                    android.widget.Toast.makeText(context, "Shuffled new topic order! 🔀", android.widget.Toast.LENGTH_SHORT).show()
                                },
                                shape = RoundedCornerShape(12.dp),
                                color = Color(0xFFE0F2FE),
                                border = BorderStroke(1.dp, Color(0xFF0284C7).copy(alpha = 0.4f))
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Shuffle,
                                        contentDescription = "Shuffle",
                                        tint = Color(0xFF0284C7),
                                        modifier = Modifier.size(14.dp)
                                    )
                                    Text(
                                        text = "Shuffle Topics",
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF0284C7)
                                    )
                                }
                            }
                        }
                    }
                }

                // Category Filter Tabs
                item {
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(categories) { category ->
                            val isSelected = selectedCategory == category
                            FilterChip(
                                selected = isSelected,
                                onClick = { selectedCategory = category },
                                label = {
                                    Text(
                                        text = category,
                                        fontSize = 12.5.sp,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                                    )
                                },
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = BentoPrimary,
                                    selectedLabelColor = Color.White,
                                    containerColor = BentoSurface,
                                    labelColor = BentoOnSurfaceVariant
                                ),
                                border = FilterChipDefaults.filterChipBorder(
                                    enabled = true,
                                    selected = isSelected,
                                    borderColor = BentoSurfaceVariant,
                                    selectedBorderColor = BentoPrimary
                                ),
                                shape = RoundedCornerShape(20.dp)
                            )
                        }
                    }
                }

                // Simulations Cards List
                if (filteredAndShuffledSims.isEmpty()) {
                    item {
                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = BentoSurface,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 20.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(24.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text("🔍", fontSize = 36.sp)
                                Text("No simulations found for '$searchQuery'", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                                Text("Try searching for 'Circuits', 'Molecule', 'Gravity', 'Optics', or 'pH'", fontSize = 12.sp, color = BentoOnSurfaceVariant, textAlign = androidx.compose.ui.text.style.TextAlign.Center)
                                Button(
                                    onClick = { searchQuery = ""; selectedCategory = "All" },
                                    modifier = Modifier.padding(top = 8.dp)
                                ) {
                                    Text("Reset Filters")
                                }
                            }
                        }
                    }
                } else {
                    items(filteredAndShuffledSims, key = { it.id }) { sim ->
                        Surface(
                            onClick = { pendingSimToLaunch = sim },
                            shape = RoundedCornerShape(18.dp),
                            color = BentoSurface,
                            border = BorderStroke(1.dp, BentoSurfaceVariant),
                            shadowElevation = 1.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("phet_sim_card_${sim.id}")
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                verticalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        Surface(
                                            shape = RoundedCornerShape(12.dp),
                                            color = sim.color.copy(alpha = 0.15f),
                                            modifier = Modifier.size(44.dp)
                                        ) {
                                            Box(contentAlignment = Alignment.Center) {
                                                Text(sim.iconEmoji, fontSize = 24.sp)
                                            }
                                        }
                                        Column {
                                            Text(
                                                text = sim.title,
                                                fontSize = 15.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = BentoOnSurface
                                            )
                                            Text(
                                                text = "${sim.subject} • ${sim.examTopic}",
                                                fontSize = 11.5.sp,
                                                fontWeight = FontWeight.Medium,
                                                color = BentoPrimary
                                            )
                                        }
                                    }

                                    Surface(
                                        shape = RoundedCornerShape(8.dp),
                                        color = sim.color.copy(alpha = 0.15f)
                                    ) {
                                        Text(
                                            text = sim.subject.uppercase(),
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = sim.color,
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                        )
                                    }
                                }

                                Text(
                                    text = sim.description,
                                    fontSize = 12.5.sp,
                                    color = BentoOnSurfaceVariant,
                                    lineHeight = 18.sp
                                )

                                if (sim.imageUrl != null) {
                                    Surface(
                                        shape = RoundedCornerShape(12.dp),
                                        color = Color.White,
                                        border = BorderStroke(1.dp, BentoSurfaceVariant),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(140.dp)
                                            .clip(RoundedCornerShape(12.dp))
                                    ) {
                                        AsyncImage(
                                            model = sim.imageUrl,
                                            contentDescription = sim.title,
                                            contentScale = ContentScale.Fit,
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(6.dp)
                                        )
                                    }
                                }

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Surface(
                                        shape = RoundedCornerShape(6.dp),
                                        color = Color(0xFFECFDF5)
                                    ) {
                                        Text(
                                            text = "FREE 3D HTML5 LAB",
                                            fontSize = 9.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color(0xFF059669),
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                                        )
                                    }

                                    Button(
                                        onClick = { pendingSimToLaunch = sim },
                                        shape = RoundedCornerShape(10.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                                        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp),
                                        modifier = Modifier.height(34.dp)
                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                                        ) {
                                            Text("Launch 3D Lab", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                            Icon(
                                                imageVector = Icons.Outlined.PlayArrow,
                                                contentDescription = null,
                                                modifier = Modifier.size(16.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Interactive HTML5 Simulation Dialog Viewer (WebView)
            if (activeSimForWebView != null) {
                val sim = activeSimForWebView!!
                AlertDialog(
                    onDismissRequest = { activeSimForWebView = null },
                    modifier = Modifier
                        .fillMaxWidth(0.96f)
                        .fillMaxHeight(0.92f),
                    properties = androidx.compose.ui.window.DialogProperties(usePlatformDefaultWidth = false)
                ) {
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = BentoSurface,
                        border = BorderStroke(1.dp, BentoSurfaceVariant)
                    ) {
                        Column(modifier = Modifier.fillMaxSize()) {
                            // Dialog Header Bar
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(BentoSurface)
                                    .padding(horizontal = 16.dp, vertical = 10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(sim.iconEmoji, fontSize = 20.sp)
                                    Column {
                                        Text(
                                            text = sim.title,
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = BentoOnSurface,
                                            maxLines = 1
                                        )
                                        Text(
                                            text = "PhET Interactive Simulations • CU Boulder",
                                            fontSize = 10.sp,
                                            color = BentoOnSurfaceVariant
                                        )
                                    }
                                }

                                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                    IconButton(
                                        onClick = {
                                            try {
                                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(sim.phetUrl))
                                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                                context.startActivity(intent)
                                            } catch (e: Exception) {
                                                android.widget.Toast.makeText(context, "Opening browser link...", android.widget.Toast.LENGTH_SHORT).show()
                                            }
                                        }
                                    ) {
                                        Icon(Icons.Outlined.OpenInNew, contentDescription = "Open in Browser", tint = BentoPrimary)
                                    }

                                    IconButton(onClick = { activeSimForWebView = null }) {
                                        Icon(Icons.Default.Close, contentDescription = "Close", tint = BentoOnSurface)
                                    }
                                }
                            }

                            HorizontalDivider(color = BentoSurfaceVariant)

                            // Embedded Interactive HTML5 WebView
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxWidth()
                                    .background(Color.Black)
                            ) {
                                AndroidView(
                                    factory = { ctx ->
                                        WebView(ctx).apply {
                                            settings.javaScriptEnabled = true
                                            settings.domStorageEnabled = true
                                            settings.loadWithOverviewMode = true
                                            settings.useWideViewPort = true
                                            settings.allowFileAccess = true
                                            webViewClient = WebViewClient()
                                            loadUrl(sim.phetUrl)
                                        }
                                    },
                                    update = { webView ->
                                        webView.loadUrl(sim.phetUrl)
                                    },
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                    }
                }
            }
            
            // Guide Dialog before launching simulation
            if (pendingSimToLaunch != null) {
                val sim = pendingSimToLaunch!!
                SimulatorIntroGuideDialog(
                    sim = sim,
                    onDismiss = { pendingSimToLaunch = null },
                    onStart = {
                        activeSimForWebView = sim
                        pendingSimToLaunch = null
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimulatorIntroGuideDialog(
    sim: PhetSimulationItem,
    onDismiss: () -> Unit,
    onStart: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        properties = androidx.compose.ui.window.DialogProperties(usePlatformDefaultWidth = false),
        modifier = Modifier
            .fillMaxWidth(0.92f)
            .fillMaxHeight(0.85f)
            .clip(RoundedCornerShape(24.dp))
    ) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = BentoSurface,
            border = BorderStroke(1.5.dp, sim.color.copy(alpha = 0.5f)),
            shadowElevation = 12.dp
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                // Scrollable Content Area
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 20.dp, vertical = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    // Header with Emoji and Title
                    Surface(
                        shape = CircleShape,
                        color = sim.color.copy(alpha = 0.15f),
                        modifier = Modifier.size(72.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(text = sim.iconEmoji, fontSize = 36.sp)
                        }
                    }
                    
                    Text(
                        text = "Interactive Lab Guide 🧪",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = BentoOnSurface
                    )
                    
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = sim.color.copy(alpha = 0.1f),
                        border = BorderStroke(1.dp, sim.color.copy(alpha = 0.3f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "💡 Tap the big button below to launch '${sim.title}'!",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = sim.color,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                    
                    // Instructions List
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        GuideStep(emoji = "👆", title = "Touch & Drag (टच करें)", desc = "Move objects around freely on the screen.")
                        GuideStep(emoji = "🎛️", title = "Change Values (वैल्यू बदलें)", desc = "Use sliders and buttons to see live results.")
                        GuideStep(emoji = "🔍", title = "Zoom In/Out (ज़ूम करें)", desc = "Pinch to zoom in or out to inspect details.")
                        GuideStep(emoji = "🔬", title = "Virtual Experiment (प्रयोग करें)", desc = "Perform safe, real physics/chemistry labs.")
                        GuideStep(emoji = "💥", title = "Experiment Freely (बेझिझक सीखें)", desc = "You cannot break it! Make mistakes & learn.")
                    }
                }
                
                HorizontalDivider(color = BentoSurfaceVariant)

                // Sticky Fixed Bottom Action Button Bar
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(BentoSurface)
                        .padding(horizontal = 20.dp, vertical = 14.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = onStart,
                        colors = ButtonDefaults.buttonColors(containerColor = sim.color),
                        shape = RoundedCornerShape(16.dp),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "Start Experiment Now ▶️",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                    
                    TextButton(
                        onClick = onDismiss,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                    ) {
                        Text("Close / बाद में करें", color = BentoOnSurfaceVariant, fontSize = 13.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun GuideStep(emoji: String, title: String, desc: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Surface(
            shape = CircleShape,
            color = BentoSurfaceVariant.copy(alpha = 0.5f),
            modifier = Modifier.size(44.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(text = emoji, fontSize = 20.sp)
            }
        }
        
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = BentoOnSurface
            )
            Text(
                text = desc,
                fontSize = 13.sp,
                color = BentoOnSurfaceVariant,
                lineHeight = 18.sp
            )
        }
    }
}

