public class TestNode {
    int testInt;
    String testString;

    public TestNode(int testInt, String testString) {
        this.testInt = testInt;
        this.testString = testString;
    }

    @Override
    public String toString() {
        return "TestNode{" +
                "testInt=" + testInt +
                ", testString='" + testString + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj instanceof TestNode)
        {
            TestNode temp = (TestNode)obj;
            return temp.testInt == this.testInt && temp.testString.equals(this.testString);
        }
        return false;
    }
}
