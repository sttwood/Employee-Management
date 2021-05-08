class Employee {
    private String fname;
    private String lname;
    private int id;
    private int age;
    private int exp;
    private String pos;

    public String getFName() 
    {
        return this.fname;
    }

    public void setFName(String fname)
    {
        this.fname = fname;
    }

    public String getLName() 
    {
        return this.lname;
    }

    public void setLName(String lname)
    {
        this.lname = lname;
    }

    public int getID()
    {
        return this.id;
    }

    public void setID(int id)
    {
        this.id = id;
    }

    public int getAge()
    {
        return this.age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getPos()
    {
        return this.pos;
    }

    public void setPos(String pos)
    {
        this.pos = pos;
    }

    public int getExp()
    {
        return this.exp;
    }

    public void setExp(int exp)
    {
        this.exp = exp;
    }

    public String toString()
    {
        return "_________________________________\n[id:" + id + "]\nName: " + fname + " " + lname + "\nAge: " + age + "\nWork experience: " + exp + " years" + "\nPosition: " + pos;
    }
}