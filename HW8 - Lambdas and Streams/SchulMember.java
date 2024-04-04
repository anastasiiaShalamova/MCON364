import java.util.Comparator;

class SchulMember implements Comparable<SchulMember> {
    private String lastNameOfMember;
    private String firstNameOfMember;
    private int birthDateOfMember;
    private String spouseFirstName;
    private String spouseLastName;
    private String[] childrenNames;
    private int yearsOfMembership;
    
    public SchulMember(String lastNameOfMember, String firstNameOfMember, 
            int birthDateOfMember, String spouseFirstName, String spouseLastName,
                String[] childrenNames, int yearsOfMembership) {
        this.lastNameOfMember = lastNameOfMember;
        this.firstNameOfMember = firstNameOfMember;
        this.birthDateOfMember = birthDateOfMember;
        this.spouseFirstName = spouseFirstName;
        this.spouseLastName = spouseLastName;
        this.childrenNames = childrenNames;
        this.yearsOfMembership = yearsOfMembership;
    }
    
    public String getLastNameOfMember() {
        return lastNameOfMember;
    }

    public void setLastNameOfMember(String lastNameOfMember) {
        this.lastNameOfMember = lastNameOfMember;
    }

    public String getFirstNameOfMember() {
        return firstNameOfMember;
    }

    public void setFirstNameOfMember(String firstNameOfMember) {
        this.firstNameOfMember = firstNameOfMember;
    }

    public int getBirthDateOfMember() {
        return birthDateOfMember;
    }

    public void setBirthDateOfMember(int birthDateOfMember) {
        this.birthDateOfMember = birthDateOfMember;
    }

    public String getSpouseFirstName() {
        return spouseFirstName;
    }

    public void setSpouseFirstName(String spouseFirstName) {
        this.spouseFirstName = spouseFirstName;
    }

    public String getSpouseLastName() {
        return spouseLastName;
    }

    public void setSpouseLastName(String spouseLastName) {
        this.spouseLastName = spouseLastName;
    }

    public String[] getChildrenNames() {
        return childrenNames;
    }

    public void setChildrenNames(String[] childrenNames) {
        this.childrenNames = childrenNames;
    }

    public int getYearsOfMembership() {
        return yearsOfMembership;
    }

    public void setYearsOfMembership(int yearsOfMembership) {
        this.yearsOfMembership = yearsOfMembership;
    }
    
    // implementing compareTo method for comparing ages of SchulMembers
    @Override
    public int compareTo(SchulMember other) {
        return Integer.compare(this.birthDateOfMember, other.birthDateOfMember);
    }

    // comparing ages of SchulMembers
    public static Comparator<SchulMember> ageComparator = new Comparator<SchulMember>() {
        @Override
        public int compare(SchulMember member1, SchulMember member2) {
            return Integer.compare(member1.birthDateOfMember, member2.birthDateOfMember);
        }
    };
}

