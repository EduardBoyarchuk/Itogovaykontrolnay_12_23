import java.util.Date;
    class Pets extends Animals {
        private String[] commands;
    
        // Конструктор
        public Pets(String name, Date birthdate, String[] commands) {
            super(name, birthdate);
            this.commands = commands;
        }
    
        // Геттеры и сеттеры
        public String[] getCommands() {
            return commands;
        }
    
        public void setCommands(String[] commands) {
            this.commands = commands;
        }
    }  
    

