## Supermarket Pricing
This kata arose from some discussions we’ve been having at the DFW Practioners meetings. The problem domain is something seemingly simple: pricing goods at supermarkets.

Some things in supermarkets have simple prices: this can of beans costs $0.65. Other things have more complex prices. For example:

three for a dollar (so what’s the price if I buy 4, or 5?)
$1.99/pound (so what does 4 ounces cost?)
buy two, get one free (so does the third item have a price?)
This kata involves no coding. The exercise is to experiment with various models for representing money and prices that are flexible enough to deal with these (and other) pricing schemes, and at the same time are generally usable (at the checkout, for stock management, order entry, and so on). Spend time considering issues such as:

does fractional money exist?
when (if ever) does rounding take place?
how do you keep an audit trail of pricing decisions (and do you need to)?
are costs and prices the same class of thing?
if a shelf of 100 cans is priced using “buy two, get one free”, how do you value the stock?
This is an ideal shower-time kata, but be careful. Some of the problems are more subtle than they first appear. I suggest that it might take a couple of weeks worth of showers to exhaust the main alternatives.

Goal
The goal of this kata is to practice a looser style of experimental modelling. Look for as many different ways of handling the issues as possible. Consider the various tradeoffs of each. What techniques are best for exploring these models? For recording them? How can you validate a model is reasonable?

## 案例分析
业务范围：pricing goods at supermarkets.
- 不同的商品定价可能不同.
- 商品的单位可能不同，比如按个、盎司、磅、重量等.
- 促销策略也可能不一样，比如买二送一、第二件8折等.
- 是否考虑辅币（小额货币：1分、2分、5分、1角、2角、5角）
- 部分商品价格具有明显的时效性（水果、鲜肉类、鲜奶类等）
## 术语分析
|术语|描述|
|----|----|
|supermarkets|商场|
|Goods|商品|
|Price|商品的价格|
|Cost|商品成本|
|Stock|商品库存|
|Shelf|货架|