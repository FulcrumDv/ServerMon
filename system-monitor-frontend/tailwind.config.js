/** @type {import('tailwindcss').Config} */
module.exports = {
  purge: ['./index.html', './src/**/*.{vue,js,ts,jsx,tsx}'],
  darkMode: false,
  theme: {
    extend: {
      colors: {
        'custom-bg': '#393c42',
      }
    },
  },
  variants: {
    extend: {},
  },
  plugins: [],
}