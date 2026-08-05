# Project Guidelines & Conventions

## Mobile Responsiveness & Layout Architecture
- **Responsive Text & Button Formatting**: Every button, chip, title, and card text must wrap cleanly across all screen sizes (from compact 4.7" phones to large foldables and tablets).
- **No Text Truncation or Squeezing**: Avoid hardcoded narrow widths on interactive buttons. Use flexible `Row`/`Column` layouts, explicit `lineHeight`, and generous `contentPadding` (e.g., `PaddingValues(horizontal = 10.dp, vertical = 8.dp)`).
- **Vector Icons over Emojis**: Use official Android Material Symbols (`Icons.Default.*`) instead of raw Unicode emojis in buttons, tabs, and headers to ensure consistent, professional rendering across all Android OS versions.

## Visual Design & Polish
- **Clean Professional Aesthetic**: Use Material 3 light design system (`BentoBackground`, `BentoSurface`, `BentoPrimary`) with high-contrast text and crisp borders.
- **High-Contrast Typography**: Important metrics, labels, and status badges should use bold/black font weights (`FontWeight.ExtraBold`, `FontWeight.Black`) to highlight key information clearly.
