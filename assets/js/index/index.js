
function showContent(sectionId) {
  const sections = document.querySelectorAll('.content-section');
  sections.forEach(section => {
    section.classList.remove('active');
  });

  const selectedSection = document.getElementById(sectionId);
  selectedSection.classList.add('active');
}

function toggleSidebar() {
  const sidebar = document.querySelector('.sidebar-icons');
  sidebar.classList.toggle('visible');
}
function adicionarItensAoMenu() {
  const sidebar = document.querySelector('.sidebar-icons');
  items.forEach(item => {
    const menuItem = document.createElement('div');
    menuItem.classList.add('menu-item');
    menuItem.innerHTML = `<i class="fas ${itemIcons[item]}"></i>`;
    menuItem.onclick = function () {
      showContent(item);
    };
    sidebar.appendChild(menuItem);
  });
}
const itemIcons = {
    'doacao': 'fa-user',
    'informacoes': 'fa-info-circle',
    'configuracoes': 'fa-cog',
};

const userData = JSON.parse(localStorage.getItem('userData'));
var items=[]
if (userData) {    
    const userName = userData.nome; 
    items = userData.itensMenu;    
    const userSpan = document.getElementById("user-name");
    userSpan.textContent = userName;
    adicionarItensAoMenu();
} else {
   
}

  
 


