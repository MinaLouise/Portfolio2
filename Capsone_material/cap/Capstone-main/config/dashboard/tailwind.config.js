/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    './src/*.html',
    './src/*.js'
  ],
  theme: {
    colors:{
      '--lavender-pink': '#FFB4CFff',
      '--aquamarine': '#7AFFB4ff',
      '--celestial-blue': '#1FA2FFff',
      '--french-rose': '#FF5694ff',
      '--light-sky-blue': '#84CCFFff',
    },
    extend:{},
  },
  variants: {
    extend: {},
  },
  plugins: [],
};

