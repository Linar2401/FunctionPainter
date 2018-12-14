# FunctionPainter
Чтобы использовать эту библиотеку, надо лишь переместить файлы библиотеки в корень проекта.

Для вызова рисовальщика вы должны использовать следущую команду:CartesianSystem #Name# = new CartesianSystem(LeftBorder, Cell count, Size)

#Name# - имя рисовальщика

LeftBorder - левая граница графика(int)

Cell count - размер квадрата координатной плоскости(int)

Size - размер итогового файла в пикселях(Он квадратный, поэтому только одна сторона)(int)

Для рисования графика вы должны вызвать команду #Name#.drawFunction(function,color)

Где function это функция заданная экземпляром класса , который расширает класс Function, либо λ-выражение,(Function or IFunction)

а color - цвет графика функции.(Color)

Вы можете нарисовать несколько графиков на одной координатной плоскости.

Для сохранения вы должны использовать команду #Name#.safe(Pathname,format),

где Pathname - имя файла с его расширением или имя вместе с путем до него,(String)

а format - расширение файла.(String)

Пример использования:

    CartesianSystem painter = new CartesianSystem(-10, 20, 880);
    
    painter.drawFunction((x) ->(x*x),Color.red);
    
    painter.drawFunction((x) ->(Math.cos(x)),Color.blue);
    
    painter.safe("ResultImages/Image.png","png");
