

def foo(inputStr):

    state = 0

    index = 0

    while index < len(inputStr):

        if state == 0:

            if inputStr[index] == '0':
                state = 1
            else:
                state = 3

        if state == 1:

            if inputStr[index] == '0':
                state = 2
            else:
                state = 1
        
        if state == 2:

            if inputStr[index] == '0':
                state = 2
            else:
                state = 1

        if state == 3:

            return False
        
    
    if state == 2:
        return True
    else:
        return False



