package ramadoka.meta.programming
import java.lang.reflect.Modifier

object Helper {
  case class MethodDefinition(method: java.lang.reflect.Method){
    def parameterTypes: List[String] = {
      method.getParameterTypes.map(_.getSimpleName).toList
    }

    def returnType: String = {
      method.getReturnType.getSimpleName
    }

    def exceptions: List[String] = {
      method.getExceptionTypes.map(_.getName).toList
    }

    def className: String = {
      method.getDeclaringClass.getSimpleName
    }

    def staticLevel: String = {
      if(Modifier.isStatic(method.getModifiers)){
        "#"
      } else {
        "."
      }
    }

    def testF(a: String): String = ""

    def name: String = {
      method.getName
    }

    def exceptionString: String = {
      if(exceptions.isEmpty) {
        ""
      } else {
        String.format(" || %s", exceptions.mkString(", "))
      }
    }

    def typeString: String = {
      if(parameterTypes.isEmpty) {
        String.format("%s", returnType)
      } else {
        String.format("(%s) -> %s", parameterTypes.mkString(" -> "), returnType)
      }
    }

    override
    def toString: String = {
      String.format(
        "\n%s%s%s :: %s%s",
        className,
        staticLevel,
        name,
        typeString,
        exceptionString
      )
    }
  }

  def methods(obj: Any): List[MethodDefinition] = {
    obj.getClass.getMethods.toList.map((method) => {
      MethodDefinition(method)
    }).toList
  }

  def help(obj: Any): Unit = {
    methods(obj).foreach(println)
  }

}
