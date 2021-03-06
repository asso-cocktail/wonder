package er.chronic.handlers;

import java.util.List;

import er.chronic.Options;
import er.chronic.repeaters.RepeaterMonthName;
import er.chronic.tags.ScalarDay;
import er.chronic.utils.Span;
import er.chronic.utils.Token;

public class RmnSdOnHandler extends MDHandler {
  public Span handle(List<Token> tokens, Options options) {
    if (tokens.size() > 3) {
      return handle(tokens.get(2).getTag(RepeaterMonthName.class), tokens.get(3).getTag(ScalarDay.class), tokens.subList(0, 2), options);
    }
    return handle(tokens.get(1).getTag(RepeaterMonthName.class), tokens.get(2).getTag(ScalarDay.class), tokens.subList(0, 1), options);
  }
}
