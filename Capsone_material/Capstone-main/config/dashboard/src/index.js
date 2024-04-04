import Alpine from 'alpinejs';
import './style.css';

Alpine.data('app', () => ({
  open: false,
}));

window.Alpine = Alpine;
Alpine.start();