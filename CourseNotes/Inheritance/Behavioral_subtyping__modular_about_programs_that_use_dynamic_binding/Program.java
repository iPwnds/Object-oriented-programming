package Behavioral_subtyping__modular_about_programs_that_use_dynamic_binding;

class Program {

    static void printLocations(Company company) {
        String[] locations = company.getLocations();
        for (int i = 0; i < 3; i++)
            System.out.println(locations[i]);
    }
    
	
//    /** 
//     * weak specification
//     * @pre | company != null 
//     */
//    static void printLocations(Company company) {
//        String[] locations = company.getLocations();
//        for (String location : locations)
//            System.out.println(location);
//    }

	
    public static void main(String[] args) {
        printLocations(new CompanyA());
    }

}