package p65;

class Solution {

    private State state;

    public boolean isNumber(String s) {
        state = new Start();

        for (int i = 0; i < s.length(); i++) {
            if (!state.next(s.charAt(i))) {
                return false;
            }
        }

        return state.end();
    }

    interface State {
        boolean next(char c);
        boolean end();
    }

    class Start implements State {

        @Override
        public boolean next(char c) {
            if (c == '+' || c == '-') {
                state = new FirstOp();
                return true;
            } else if (Character.isDigit(c)) {
                state = new FirstNumBeforeDot();
                return true;
            } else if (c == '.') {
                state = new FirstDot(false);
                return true;
            } else {
                return false;
            }
        }

        @Override
        public boolean end() {
            return false;
        }
    }

    class FirstOp implements State {

        @Override
        public boolean next(char c) {
            if (Character.isDigit(c)) {
                state = new FirstNumBeforeDot();
                return true;
            } else if (c == '.') {
                state = new FirstDot(false);
                return true;
            } else {
                return false;
            }
        }

        @Override
        public boolean end() {
            return false;
        }
    }

    class FirstNumBeforeDot implements State {

        @Override
        public boolean next(char c) {
            if (Character.isDigit(c)) {
              return true;
            } else if (c == '.') {
                state = new FirstDot(true);
                return true;
            } else if (c == 'e' || c == 'E') {
                state = new E();
                return true;
            } else {
                return false;
            }
        }

        @Override
        public boolean end() {
            return true;
        }
    }

    class FirstDot implements State {

        private boolean hasNumBefore;

        public FirstDot(boolean hasNumBefore) {
            this.hasNumBefore = hasNumBefore;
        }

        @Override
        public boolean next(char c) {
            if (Character.isDigit(c)) {
                state = new FirstNUmAfterDot();
                return true;
            } else if (c == 'e' || c == 'E') {
                if (hasNumBefore) {
                    state = new E();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override
        public boolean end() {
            return hasNumBefore;
        }
    }

    class FirstNUmAfterDot implements State {

        @Override
        public boolean next(char c) {
            if (Character.isDigit(c)) {
                return true;
            } else if (c == 'e' || c == 'E') {
                state = new E();
                return true;
            } else {
                return false;
            }
        }

        @Override
        public boolean end() {
            return true;
        }
    }

    class E implements State {

        @Override
        public boolean next(char c) {
            if (c == '+' || c == '-') {
                state = new SecondOp();
                return true;
            } else if (Character.isDigit(c)) {
                state = new SecondNum();
                return true;
            } else {
                return false;
            }
        }

        @Override
        public boolean end() {
            return false;
        }
    }

    class SecondOp implements State {

        @Override
        public boolean next(char c) {
            if (Character.isDigit(c)) {
                state = new SecondNum();
                return true;
            } else {
                return false;
            }
        }

        @Override
        public boolean end() {
            return false;
        }
    }

    class SecondNum implements State {

        @Override
        public boolean next(char c) {
            if (Character.isDigit(c)) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public boolean end() {
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isNumber("+.8"));
    }
}
