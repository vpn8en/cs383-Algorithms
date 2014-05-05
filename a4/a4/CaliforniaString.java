package a4;
public class CaliforniaString implements Comparable<CaliforniaString> {
    final String string;

    public CaliforniaString(String string) {
            this.string = string;
    }
    
    public int length() {
            return string.length();
    }

    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((string == null) ? 0 : string.hashCode());
            return result;
    }

    @Override
    public boolean equals(Object obj) {
            if (this == obj)
                    return true;
            if (obj == null)
                    return false;
            if (getClass() != obj.getClass())
                    return false;
            CaliforniaString other = (CaliforniaString) obj;
            if (string == null) {
                    if (other.string != null)
                            return false;
            } else if (!string.equals(other.string))
                    return false;
            return true;
    }

    //Declares the specified order to compare against, returns 1,-1,0
    
    public int compareTo(CaliforniaString that) {
            String newOrder = "RWQOJMVAHBSGZXNTCIEKUPDYFL";
            if (this.string.equals(that.string)) return 0;
            int n = Math.min(that.length(), this.length());
            for (int i=0; i<n; i++) {
                    int c1 = newOrder.indexOf(this.string.charAt(i));
                    int c2 = newOrder.indexOf(that.string.charAt(i));
                    if (c1 < c2) return -1;
                    else if (c2 < c1) return 1;
            }
            
            if(this.length() > that.length()) return 1;
            return -1;
    }

    @Override
    public String toString() {
            return string;
    }
}