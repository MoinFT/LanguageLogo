package de.moinFT.utils;

public class Functions {
    public static String format(String input) {
        StringBuilder output = new StringBuilder();
        input = input.toUpperCase();

        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case 'H':
                case 'R':
                case 'W':
                case 'V':
                case 'D':
                case '{':
                case '}':
                case ';':
                    output.append(input.charAt(i));
                    break;
            }
        }

        return output.toString();
    }

    public static String replaceNumbers(String input) {
        StringBuilder output = new StringBuilder();
        input = input.toUpperCase();

        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    output.append("1");
                    break;
                default:
                    output.append(input.charAt(i));
                    break;
            }
        }

        output.append("#");

        return output.toString();
    }

    public static int[] parse(String input) {
        int status = 0;
        int space = 0;
        char c;

        while (input.length() > 0) {
            c = input.charAt(0);
            if (input.length() > 1) {
                input = input.substring(1);
            } else {
                input = "";
            }

            switch (status) {
                case 0:
                    switch (c) {
                        case 'H':
                        case 'R':
                            status = 1;
                            break;
                        case 'V':
                        case 'D':
                            status = 3;
                            break;
                        case 'W':
                            status = 5;
                            break;
                        case '1':
                            status = 101;
                            break;
                        case '{':
                        case '}':
                            status = 102;
                            break;
                        case ';':
                            status = 103;
                            break;
                        default:
                            status = 99;
                            break;
                    }
                    break;
                case 1:
                    switch (c) {
                        case ';':
                            status = 2;
                            break;
                        default:
                            status = 104;
                            break;
                    }
                    break;
                case 2:
                    switch (c) {
                        case 'H':
                        case 'R':
                            status = 1;
                            break;
                        case 'V':
                        case 'D':
                            status = 3;
                            break;
                        case 'W':
                            status = 5;
                            break;
                        case '1':
                            status = 101;
                            break;
                        case '{':
                        case '}':
                            status = 102;
                            break;
                        case ';':
                            status = 103;
                            break;
                        case '#':
                            status = 90;
                            break;
                        default:
                            status = 99;
                            break;
                    }
                    break;
                case 3:
                    switch (c) {
                        case '1':
                            status = 4;
                            break;
                        default:
                            status = 105;
                            break;
                    }
                    break;
                case 4:
                    switch (c) {
                        case '1':
                            status = 4;
                            break;
                        case ';':
                            status = 2;
                            break;
                        default:
                            status = 106;
                            break;
                    }
                    break;
                case 5:
                    switch (c) {
                        case '1':
                            status = 6;
                            break;
                        default:
                            status = 105;
                            break;
                    }
                    break;
                case 6:
                    switch (c) {
                        case '1':
                            status = 6;
                            break;
                        case '{':
                            status = 7;
                            break;
                        default:
                            status = 107;
                            break;
                    }
                    break;
                case 7:
                    switch (c) {
                        case 'H':
                        case 'R':
                            status = 8;
                            break;
                        case 'V':
                        case 'D':
                            status = 11;
                            break;
                        case 'W':
                            status = 108;
                            break;
                        case '1':
                            status = 101;
                            break;
                        case '{':
                        case '}':
                            status = 102;
                            break;
                        case ';':
                            status = 103;
                            break;
                        default:
                            status = 99;
                            break;
                    }
                    break;
                case 8:
                    switch (c) {
                        case ';':
                            status = 9;
                            break;
                        default:
                            status = 104;
                            break;
                    }
                    break;
                case 9:
                    switch (c) {
                        case 'H':
                        case 'R':
                            status = 8;
                            break;
                        case 'V':
                        case 'D':
                            status = 11;
                            break;
                        case '}':
                            status = 10;
                            break;
                        case 'W':
                            status = 108;
                            break;
                        case '1':
                        case '{':
                        case ';':
                            status = 109;
                            break;
                        default:
                            status = 99;
                            break;
                    }
                    break;
                case 10:
                    switch (c) {
                        case 'H':
                        case 'R':
                            status = 1;
                            break;
                        case 'V':
                        case 'D':
                            status = 3;
                            break;
                        case 'W':
                            status = 5;
                            break;
                        case '1':
                            status = 101;
                            break;
                        case '{':
                        case '}':
                            status = 102;
                            break;
                        case ';':
                            status = 103;
                            break;
                        case '#':
                            status = 90;
                            break;
                        default:
                            status = 99;
                            break;
                    }
                    break;
                case 11:
                    switch (c) {
                        case '1':
                            status = 12;
                            break;
                        default:
                            status = 105;
                            break;
                    }
                    break;
                case 12:
                    switch (c) {
                        case '1':
                            status = 12;
                            break;
                        case ';':
                            status = 13;
                            break;
                        default:
                            status = 106;
                            break;
                    }
                    break;
                case 13:
                    switch (c) {
                        case 'H':
                        case 'R':
                            status = 8;
                            break;
                        case 'V':
                        case 'D':
                            status = 11;
                            break;
                        case '}':
                            status = 10;
                            break;
                        case 'W':
                            status = 108;
                            break;
                        case '1':
                        case '{':
                        case ';':
                            status = 109;
                            break;
                        default:
                            status = 99;
                            break;
                    }
                    break;
            }

            if (status < 99) {
                space++;
            }
        }

        return new int[]{status, space};
    }
}
