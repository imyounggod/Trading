package com.devcraft.trading.presentation.main

import com.devcraft.trading.R
import com.devcraft.trading.domain.model.CurrencyPair
import com.devcraft.trading.domain.model.Guide
import java.util.*
import kotlin.random.Random

data class MainState(
    var text: Int = 0,
    var guides: List<Guide> = listOf(
        Guide(
            id = 0,
            image = R.drawable.guide1,
            title = "Day Trading using Options",
            content =  """With options offering leverage and loss-limiting capabilities, it would seems like day trading options would be a great idea. In reality, however, the day trading option strategy faces a couple of problems.

Firstly, the time value component of the option premium tends to dampen any price movement. For near-the-money options, while the intrinsic value may go up along with the underlying stock price, this gain is offset to a certain degree by the loss of time value.

Secondly, due to the reduced liquidity of the options market, the bid-ask spreads are usually wider than for stocks, sometimes up to half a point, again cutting into the limited profit of the typical daytrade.

So if you are planning to day trade options, you must overcome this two problems.

Your DayTrading Options: Near-month and In-The-Money

For daytrading purposes, we want to use options with as little time value as possible and with delta as close to 1.0 as we can get. So if you are going to daytrade options, then you should daytrade the near month in-the-money options of highly liquid stocks.

We daytrade with near-month in-the-money options because in-the-money options have the least amount of time value and have the greatest delta, compared to at-the-money or out-of-the-money options.

Furthermore, as we get closer to expiration, the option premium is increasingly based on the intrinsic value, and so the underlying price changes will have a greater impact, bringing you closer to realising point-for-point movements of the underlying stock. Near month options are also more heavily traded than longer term options, hence they are also more liquid.

The more popular and more liquid the underlying stock, the smaller the bid-ask spread for the corresponding options market.

When properly executed, daytrading using options allow you to invest with less capital than if you actually bought the stock, and in the event of a catastrophic collapse of the underlying stock price, your loss is limited to only the premium paid.

Another Day Trading Option: The Protective Put

If you are planning to daytrade a particular stock for short upside moves for the next few months, you can purchase protective put options to insure against a devastating stock crash.
"""
        ),
        Guide(
            id = 1,
            image = R.drawable.guide2,
            title = "Difference between a Futures Contract and a Forward Contract",
            content = """Futures and forwards are financial contracts which are very similar in nature but there exist a few important differences:

    • Futures contracts are highly standardized whereas the terms of each forward contract can be privately negotiated.
    • Futures are traded on an exchange whereas forwards are traded over-the-counter.

Counterparty risk

In any agreement between two parties, there is always a risk that one side will renege on the terms of the agreement. Participants may be unwilling or unable to follow through the transaction at the time of settlement. This risk is known as counterparty risk.

In a futures contract, the exchange clearing house itself acts as the counterparty to both parties in the contract. To further reduce credit risk, all futures positions are marked-to-market daily, with margins required to be posted and maintained by all participants at all times. All this measures ensures virtually zero counterparty risk in a futures trade.

Forward contracts, on the other hand, do not have such mechanisms in place. Since forwards are only settled at the time of delivery, the profit or loss on a forward contract is only realized at the time of settlement, so the credit exposure can keep increasing. Hence, a loss resulting from a default is much greater for participants in a forward contract.

Secondary Market

The highly standardized nature of futures contracts makes it possible for them to be traded in a secondary market.

The existence of an active secondary market means that if at anytime a participant in a futures contract wishes to transfer his obligation to another party, he can do so by selling it to another willing party in the futures market.

In contrast, there is essentially no secondary market for forward contracts.
"""
        ),
        Guide(
            id = 2,
            image = R.drawable.guide3,
            title = "Put-Call Ratio",
            content = """Definition:

The Put-Call Ratio is the number of put options traded divided by the number of call options traded in a given period.

While typically the trading volume is used to compute the Put-Call Ratio, it is sometimes calculated using open interest volume or total dollar value instead. Weekly or monthly figures can also be calculated and moving averages are often used to smooth out the short term daily figures.

How to interpret the put call ratio

The average value for the put-call ratio is not 1.00 due to the fact that equity options traders and investors almost always buy more calls than puts. Hence, the average ratio is often far less than 1.00 (usually around 0.70) for stock options.

When the ratio is close to 1.00 or greater, it indicates a bearish sentiment. The higher than average number indicates more puts being bought relative to calls. This means that more traders are betting against the underlying and hence the general outlook is bearish. Conversely, when the ratio is near 0.50 or lesser, it implies a bullish sentiment.

The put call ratio as a contrarian indicator

To the contrarian investor, the put call ratio can be used to determine when the investing crowd may be getting either too bullish or too bearish. A high put call ratio is a bullish sign as the it points to an over-bearish crowd - and vice versa.

Equity put call ratio vs. Index put call ratio

A popular strategy used by fund managers involves the buying of index put options to protect their portfolios. As a result, the put call ratio for index options is generally higher than that for equity options. Hence, for a better indicator of the sentiment of the speculative crowd, the equity put call ratio is used instead.
"""
        ),
        Guide(
            id = 3,
            image = R.drawable.guide4,
            title = "Buying Straddles into Earnings",
            content = """Buying straddles is a great way to play earnings. Many a times, stock price gap up or down following the quarterly earnings report but often, the direction of the movement can be unpredictable. For instance, a sell off can occur even though the earnings report is good if investors had expected great results.

The strategy here is to buy the straddle two to three weeks ahead of earnings. Significant price movement is necessary for a straddle to make money and in the case of the earnings play, there are three events that can occur during this period which can create price movements sufficient enough to generate a profit.

Prior to the earnings, excitement abound and the underlying stock price may trade up or down ahead of the actual earnings due to increased speculation. Sometimes, price may move so much that you may be able to exit the position with a small profit without holding into earnings.

Immediately after the earnings annoucement, stock price can often gap up or down 3% to 5%, depending on the report. Movements of 5% to 10% are seldom but not uncommon. Rare is the case when stock price remains unchanged.

A third event, unlikely but not impossible, is the profit warning that may be issued a few weeks prior to the earnings report. Large downward movements are typical following such warnings and are usually big enough to allow for a profitable exit.

Unless you are very certain that the gap up or down after the report will be huge, never buy the straddle just one day before earnings as this is the time when the premiums of at-the-money options get bid up very high due to heightened anticipation. Do your homework and scout for companies announcing earnings two to three weeks in advance. Lookout for stocks displaying a history of gap movements during earnings by examining the historical price chart.
"""
        ),
        Guide(
            id = 4,
            image = R.drawable.guide5,
            title = "Leverage using Calls, Not Margin Calls",
            content = """To achieve higher returns in the stock market, besides doing more homework on the companies you wish to buy, it is often necessary to take on higher risk. A most common way to do that is to buy stocks on margin.

Buying on margin lets the investor use stocks as collateral to borrow money to buy more stock. Currently, investors can borrow up to half the value of the stock they wish to purchase. Your broker gladly loans you as much money as you put up, and charges you a very attractive interest rate. If the stock goes up by ${'$'}1, you gain ${'$'}2 since you have now have twice the number of shares. Higher risk, higher profit.

Suppose you have ${'$'}10000 and wish to buy some shares of XYZ stock currently trading at ${'$'}50. That amount will only allow you to buy 200 shares. Buying on margin lets you borrow another ${'$'}10000 so you can buy a total of 400 shares. The total investment is ${'$'}20000.

Buying on margin, however, is like a sword that cuts both ways. While its nice to know that you are earning ${'$'}2 every time the share price goes up by ${'$'}1, the converse is true. Every time the stock drops by a dollar, you also lose ${'$'}2. Worse yet, if the stock price comes crashing down, you get the dreaded margin call and may be forced to sell the stock at the very time when you would rather be buying it instead.
 
Alternatively, with call options, you pay a premium for a right to purchase the underlying stock at a predetermined price (strike price) for a period of time - up to 2 years with LEAPS® options. In simpler terms, buying call options is like renting the underlying stock. Each call option represents 100 shares.

Following the same example above, suppose a 3 month call option on XYZ stock with strike price of ${'$'}50 is available for ${'$'}3 each. To control the same amount of XYZ stock, which is 400 shares, requires the purchase of 4 call options for a total investment of only ${'$'}1200. This is also the maximum amount you can lose if you are wrong about the stock. Comparatively, leveraging using margin requires a hefty ${'$'}20000 and worse still, you risk a margin call!

Hence, buying on margin is a dangerous way to gain leverage, especially when the underlying stock is very volatile. A better option will be to buy call options instead. In options trading, the purchase of call options is better known as a call buying or long call strategy
"""
        ),
        Guide(
            id = 5,
            image = R.drawable.guide6,
            title = "Writing Puts to Purchase Stocks",
            content = """If you are very bullish on a particular stock for the long term and is looking to purchase the stock but feels that it is slightly overvalued at the moment, then you may want to consider writing put options on the stock as a means to acquire it at a discount.

So, instead of entering a limit order to purchase the stock, you can write an equivalent amount of near-month slightly out-of-the-money naked puts with a strike price that is equal to the target price at which you wish to purchase the underlying stock.

Thereafter, on expiration date, if the stock price and your sentiments towards the underlying stock remains unchanged, the puts that you sold will expire worthless. This lets you pocket the premiums received and write some more put options.

Should the stock price take a dive and goes below the put strike price, you can either follow through with your obligation and pickup the stock or you can buy back the put options at a loss. The decision you make will depend on whether your outlook towards the underlying stock has changed since taking up the position.

You should probably buy back the put options at a loss if a significant piece of bad news had surfaced which negatively impacted the fundamentals of the underlying stock, causing you to be no longer bullish on the stock. The premiums that you received should help to cushion some of the losses.

Otherwise, if the drop in stock price is minor and your target price is hit, you will be able to buy the stock at a reasonable discount along with the extra premiums received from the sale of the put options.
"""
        ),
        Guide(
            id = 6,
            image = R.drawable.guide7,
            title = "Five tips for choosing an options trading broker",
            content = """
1. Look for a free education
If you’re new to trading options or want to expand your options trading strategies, finding a broker that has resources for educating customers is a must. That education can come in many forms, including:
    • Online options trading courses.
    • Live or recorded webinars.
    • One-on-one guidance online or by phone.
    • Face-to-face meetings with a larger broker that has branches across the country.
It’s a good idea to spend a while in student-driver mode and soak up as much education and advice as you can. Even better, if a broker offers a simulated version of its options trading platform, test-drive the process with a paper trading account before putting any real money on the line.
 
2. Put your broker’s customer service to the test
Reliable customer service should be a high priority, particularly for newer options traders. It’s also important for those who are switching brokers or conducting complex trades they may need help with.
Consider what kind of contact you prefer. Live online chat? Email? Phone support? Does the broker have a dedicated trading desk on call? What hours is it staffed? Is technical support available 24/7 or only weekdays? What about representatives who can answer questions about your account?
Before you apply for an account, reach out and ask questions to see if the answers and response time are satisfactory.
 
3. Make sure the trading platform is easy to use
Options trading platforms come in all shapes and sizes. They can be web- or software-based, desktop or online only, have separate platforms for basic and advanced trading, offer full or partial mobile functionality, or some combination of all of these.
Visit a broker’s website and look for a guided tour of its platform and tools. Screenshots and video tutorials are nice, but trying out a broker’s simulated trading platform, if it has one, will give you the best sense of whether the broker is a good fit. Some things to consider:
    • Is the platform design user-friendly or do you have to hunt and peck to find what you need?
    • How easy is it to place a trade?
    • Can the platform do the things you need, such as creating alerts based on specific criteria or letting you fill out a trade ticket in advance to submit later?
    • Will you need mobile access to the full suite of services when you’re on the go, or will a pared-down version of the platform suffice?
    • How reliable is the website, and how speedily are orders executed? This is a high priority if your strategy involves quickly entering and exiting positions.
    • Does the broker charge a monthly or annual platform fee? If so, are there ways to get the fee waived, such as keeping a minimum account balance or conducting a certain number of trades during a specific period?
 
4. Assess the breadth, depth and cost of data and tools
Data and research are an options trader’s lifeblood. Some of the basics to look for are:
    • A frequently updated quotes feed.
    • Basic charting to help pick your entry and exit points.
    • The ability to analyze a trade’s potential risks and rewards (maximum upside and maximum downside).
    • Screening tools.
Those venturing into more advanced trading strategies may need deeper analytical and trade modeling tools, such as customizable screeners; the ability to build, test, track and back-test trading strategies; and real-time market data from multiple providers.
Check to see if the fancy stuff costs extra. For example, many brokers provide free delayed quotes, lagging 20 minutes behind market data, but charge a fee for a real-time feed. Similarly, some pro-level tools may be available only to customers who meet monthly or quarterly trading activity or account balance minimums.

5. Don’t weigh the price of commissions too heavily
There’s a reason commission costs are lower on our list: Price isn’t everything, and it’s certainly not as important as the other items we’ve covered. But because commissions provide a convenient side-by-side comparison, they often are the first things people look at when picking an options broker.
A few things to know about how much brokers charge to trade options:
    • The two components of an options-trading commission are the base rate — essentially the same thing as the trading commission that investors pay when they buy a stock — and the per-contract fee. Commissions have come way down recently; many brokers now offer free commissions, while contract fees are typically between 50 cents and ${'$'}1 per contract.
    • Some brokers bundle the trading commission and the per-contract fee into a single flat fee.
    • Some brokers also offer discounted commissions or contract fees based on trading frequency, volume or average account balance. The definition of “high volume” or “active trader” varies by brokerage.
If you’re new to options trading or use the strategy only sparingly, you may be well-served by choosing either a broker that offers a single flat rate to trade or one that charges no commission (you probably won’t be able to avoid the per-contract fee). If you’re a more active trader, consider reviewing your trading cadence to see if a tiered pricing plan would save you money.
"""
        ),
        Guide(
            id = 7,
            image = R.drawable.guide8,
            title = "Options Trading Strategies For Beginners",
            content = """Once you know the basics of how options work, putting options trading strategies in place marks the next step.

Options trading strategies run the gamut from straightforward "one-legged" trades to exotic “multi-legged” beasts. But what all options strategies have in common is that they’re based on two fundamental option types: calls and puts. (If you don’t already have a strong understanding of these terms, be sure to learn the basics of call options and put options.)
The best option for beginners is to keep it simple. The following options trading strategies are designed for beginners and are "one-legged," which means they use just one option in the trade.
Note: Simple doesn’t mean risk-free — only that the following strategies are less complicated than more advanced multi-legged options strategies.
 
The long call
The long call is an options strategy where you buy a call option, or “go long.” This straightforward strategy is a wager that the underlying stock will rise above the strike price by expiration.
Example: XYZ stock trades at ${'$'}50 per share, and a call at a ${'$'}50 strike is available for ${'$'}5 with an expiration in six months. The contract is for 100 shares, which means this call costs ${'$'}500: the ${'$'}5 premium x 100. Here’s the payoff profile of one long call contract.
Potential upside/downside: If the call is well-timed, the upside on a long call is theoretically infinite, until the expiration, as long as the stock moves higher. Even if the stock moves the wrong way, traders often can salvage some of the premium by selling the call before expiration. The downside is a complete loss of the premium paid — ${'$'}500 in this example.
Why use it: If you’re not concerned about losing the entire premium, a long call is a way to wager on a stock rising and to earn much more profit than if you owned the stock directly. It can also be a way to limit the risk of owning the stock directly. For example, some traders might use a long call rather than owning a comparable number of shares of stock because it gives them upside while limiting their downside to just the call's cost — versus the much higher expense of owning the stock — if they worry a stock might fall in the interim.
 
The long put
The long put is similar to the long call, except that you’re wagering on a stock’s decline rather than its rise. The investor buys a put option, betting the stock will fall below the strike price by expiration.
Example: XYZ stock trades at ${'$'}50 per share, and a put at a ${'$'}50 strike is available for ${'$'}5 with an expiration in six months. In total, the put costs ${'$'}500: the ${'$'}5 premium x 100 shares. Here’s the payoff profile of one long put contract.
Potential upside/downside: The long put is worth the most when the stock is at ${'$'}0 per share, so its maximal value is the strike price x 100 x the number of contracts. In this example, that’s ${'$'}5,000. Even if the stock rises, traders can still sell the put and often save some of the premium, as long as there’s some time to expiration. The maximum downside is a complete loss of the premium, or ${'$'}500 here.
Why use it: A long put is a way to wager on a stock’s decline, if you can stomach the potential loss of the whole premium. If the stock declines significantly, traders will earn much more by owning puts than they would by short-selling the stock. Some traders might use a long put to limit their potential losses, compared with short-selling, where the risk is uncapped because theoretically a stock’s price could continue rising indefinitely and a stock has no expiration.
 
The short put
The short put is the opposite of the long put, with the investor selling a put, or “going short.” This strategy wagers that the stock will stay flat or rise until the expiration, with the put expiring worthless and the put seller walking away with the whole premium. Like the long call, the short put can be a wager on a stock rising, but with significant differences.
Example: XYZ stock trades at ${'$'}50 per share, and a put at a ${'$'}50 strike can be sold for ${'$'}5 with an expiration in six months. In total, the put is sold for ${'$'}500: the ${'$'}5 premium x 100 shares. The payoff profile of one short put is exactly the opposite of the long put.
Potential upside/downside: Whereas a long call bets on a significant increase in a stock, a short put is a more modest bet and pays off more modestly. While the long call can return multiples of the original investment, the maximum return for a short put is the premium, or ${'$'}500, which the seller receives upfront.
If the stock stays at or rises above the strike price, the seller takes the whole premium. If the stock sits below the strike price at expiration, the put seller is forced to buy the stock at the strike, realizing a loss. The maximum downside occurs if the stock falls to ${'$'}0 per share. In that case, the short put would lose the strike price x 100 x the number of contracts, or ${'$'}5,000.
Why use it: Investors often use short puts to generate income, selling the premium to other investors who are betting that a stock will fall. Like someone selling insurance, put sellers aim to sell the premium and not get stuck having to pay out. However, investors should sell puts sparingly, because they’re on the hook to buy shares if the stock falls below the strike at expiration. A falling stock can quickly eat up any of the premiums received from selling puts.
Sometimes investors use a short put to bet on a stock’s appreciation, especially since the trade requires no immediate outlay. But the strategy’s upside is capped, unlike a long call, and it retains more substantial downside if the stock falls.
Investors also use short puts to achieve a better buy price on a too-expensive stock, selling puts at a much lower strike price, where they’d like to buy the stock. For example, with XYZ stock at ${'$'}50, an investor could sell a put with a ${'$'}40 strike price for ${'$'}2, then:
    • If the stock dips below the strike at expiration, the put seller is assigned the stock, with the premium offsetting the purchase price. The investor pays a net ${'$'}38 per share for the stock, or the ${'$'}40 strike price minus the ${'$'}2 premium already received.
    • If the stock remains above the strike at expiration, the put seller keeps the cash and can try the strategy again.
 
The covered call
The covered call starts to get fancy because it has two parts. The investor must first own the underlying stock and then sell a call on the stock. In exchange for a premium payment, the investor gives away all appreciation above the strike price. This strategy wagers that the stock will stay flat or go just slightly down until expiration, allowing the call seller to pocket the premium and keep the stock.
If the stock sits below the strike price at expiration, the call seller keeps the stock and can write a new covered call. If the stock rises above the strike, the investor must deliver the shares to the call buyer, selling them at the strike price.
One critical point: For each 100 shares of stock, the investor sells at most one call; otherwise, the investor would be short “naked” calls, with exposure to potentially uncapped losses if the stock rose. Nevertheless, covered calls transform an unattractive options strategy — naked calls — into a safer and still potentially effective one, and it’s a favorite among investors looking for income.
Example: XYZ stock trades at ${'$'}50 per share, and a call at a ${'$'}50 strike can be sold for ${'$'}5 with an expiration in six months. In total, the call is sold for ${'$'}500: the ${'$'}5 premium x 100 shares. The investor buys or already owns 100 shares of XYZ.
Potential upside/downside: The maximum upside of the covered call is the premium, or ${'$'}500, if the stock remains at or just below the strike price at expiration. As the stock rises above the strike price, the call option becomes more costly, offsetting most stock gains and capping upside. Because upside is capped, call sellers might lose a stock profit that they otherwise would have made by not setting up a covered call, but they don’t lose any new capital. Meantime, the potential downside is a total loss of the stock’s value, less the ${'$'}500 premium, or ${'$'}4,500.
Why use it: The covered call is a favorite of investors looking to generate income with limited risk while expecting the stock to remain flat or slightly down until the option’s expiration.
Investors can also use a covered call to receive a better sell price for a stock, selling calls at an attractive higher strike price, at which they’d be happy to sell the stock. For example, with XYZ stock at ${'$'}50, an investor could sell a call with a ${'$'}60 strike price for ${'$'}2, then:
    • If the stock rises above the strike at expiration, the call seller must sell the stock at the strike price, with the premium as a bonus. The investor receives a net ${'$'}62 per share for the stock, or the ${'$'}60 strike price plus the ${'$'}2 premium already received.
    • If the stock remains below the strike at expiration, the call seller keeps the cash and can try the strategy again.
 
 
The married put
Like the covered call, the married put is a little more sophisticated than a basic options trade. It combines a long put with owning the underlying stock, “marrying” the two. For each 100 shares of stock, the investor buys one put. This strategy allows an investor to continue owning a stock for potential appreciation while hedging the position if the stock falls. It works similarly to buying insurance, with an owner paying a premium for protection against a decline in the asset.
Example: XYZ stock trades at ${'$'}50 per share, and a put at a ${'$'}50 strike is available for ${'$'}5 with an expiration in six months. In total, the put costs ${'$'}500: the ${'$'}5 premium x 100 shares. The investor already owns 100 shares of XYZ. Potential upside/downside: The upside depends on whether the stock goes up or not. If the married put allowed the investor to continue owning a stock that rose, the maximum gain is potentially infinite, minus the premium of the long put. The put pays off if the stock falls, generally matching any declines and offsetting the loss on the stock minus the premium, capping downside at ${'$'}500. The investor hedges losses and can continue holding the stock for potential appreciation after expiration.
Why use it: It’s a hedge. Investors use a married put if they’re looking for continued stock appreciation or are trying to protect gains they’ve already made while waiting for more.
"""
        ),
        Guide(
            id = 8,
            image = R.drawable.guide9,
            title = "Options contract definitions",
            content = """There are four key things to know on an options contract:
1. Option type: There are two types of options you can can buy or sell:
    • Call: An options contract that gives you the right to buy stock at a set price within a certain time period.
    • Put: An options contract that gives you the right to sell stock at a set price within a certain time period.
2. Expiration date: The date when the options contract becomes void. It’s the due date for you to do something with the contract, and it can be days, weeks, months or years in the future.
3. Strike price, or exercise price: The price at which you can buy or sell the stock if you choose to exercise the option.
4. Premium: The per-share price you pay for an option. The premium consists of:
    • Intrinsic value: The value of an option based on the difference between a stock’s current market price and the option’s strike price.
    • Time value: The value of an option based on the amount of time before the contract expires. Time is valuable to investors because of the possibility that an option’s intrinsic value will increase during the contract’s time frame. As the expiration date approaches, time value decreases. This is known as time decay or "theta," after the options pricing model used to calculate it.
 
 
Terms to describe what an option is worth

When it comes to describing options performance, saying “up,” “down” or “flat” doesn’t cut it. At any given moment that an options contract is in play, it is one of three things:
In the money: This refers to an option that has intrinsic value — when the relationship between stock price in the open market and the strike price favors the options contract owner. When the stock price is higher than the strike price, that’s good news for the owner of a call option. A put option is in the money if the stock price is lower than the strike price.
Out of the money: When there's no financial benefit to exercising the option, it's called out of the money. Practically speaking, an out-of-the-money option makes buying or selling shares at the strike price less lucrative than buying or selling on the open market. A call option is out of the money if the stock price is lower than the strike price. A put option is out of the money when the stock price is higher than the strike price.
At the money: When the stock price is roughly equal to the strike price, an option is considered at the money. Basically, it’s a wash.
 
 
Options buyer and seller terms

These last two cover types of options traders. This is another case where traditional terms like “buyer” and “seller” don’t quite capture the nuances of options trading.
Holder: Refers to the investor who owns an options contract. A call holder pays for the option to buy the stock based on the parameters of the contract. A put holder has the right to sell the stock.
Writer: Refers to the investor who is selling the options contract. The writer receives the premium from the holder in exchange for the promise to buy or sell the specified shares at the strike price, if the holder exercises the option.
Besides being on opposite sides of the transaction, the biggest difference between options holders and options writers is their exposure to risk.
Remember, holders are purchasing the right to buy or sell shares, but they aren't obligated to do anything. Their contract grants them the freedom to decide when — or if — to exercise the option, or to sell the contract before it expires. If they end up with an out-of-the-money option, they can walk away and let the contract expire. They lose only the amount they paid for the option (the premium) plus the cost of trade commissions.
Writers don’t have that flexibility. For example, when a call holder decides to exercise an option, the writer is obligated to fulfill the order and sell the stock at the strike price. If the writer doesn’t already own enough shares of the stock, he'll have to buy shares at the going market price — even if it’s higher than the strike price — and sell them at a loss to the call holder.
Because of the unlimited downside potential, we recommend that investors just getting started in options stick to the buying (holding) side before venturing into more sophisticated options trading strategies.
"""
        ),
        Guide(
            id = 9,
            image = R.drawable.guide10,
            title = "Stock option quotes explained",
            content = """Call up a stock quote and you get the current market share price of the company — the amount you’d pay if you bought shares or the amount you’d receive if you sold them. Quotes for options contracts are a lot more complex, because multiple versions are available to trade based on type, expiration date, strike price and more.
 
Strike: The price you'd pay or receive if you exercised the option.
Contract name: Just like stocks have ticker symbols, options contracts have option symbols with letters and numbers that correspond to the details in a contract. In a real option chain, the company’s ticker symbol would come before the contract name.
Last: The price that was paid or received the last time the option was traded.
Bid: The price a buyer is willing to pay for the option. If you're selling an option, this is the premium you'd receive for the contract.
Ask: The price a seller is willing to accept for the option. If you want to buy an option, this is the premium you'd pay.
Change: The price change since the previous trading day’s close, also expressed in percentage terms.
Volume: The number of contracts traded that day.
Open interest: The number of options contracts currently in play.
Volatility: A measurement of how much a stock price swings between the high and low price each day. Historic volatility, as the name implies, is calculated using past price data. It can be measured on an annual basis or during a certain time frame.
Implied volatility, or “IV” in options-quote shorthand, measures how likely it is that the market thinks a stock will experience a price swing. (You also might hear of "vega," the option pricing model used to measure the theoretical effect that each one-point change in the stock price has on implied volatility.)
Higher implied volatility typically means higher option prices because of higher potential upside for the contract. But don’t take these calculations as certainties. Just as earnings estimates are merely an analyst’s prediction of what a company is likely to earn, volatility measures are only predictions about how much an option’s price may change.
"""
        ),
        Guide(
            id = 10,
            image = R.drawable.guide11,
            title = "Binary options over the weekend",
            content = """Binary options trading over the weekend isn’t usually possible, because the stock market is closed, stocks and commodity prices don’t really move, so we have nothing to predict, since there are no movements happening.

There are, however, a few brokers that allow you to trade over the weekend. You usually trade indices or cryptocurrencies and their volatility isn’t high. Also, the profits are usually fairly low. That’s why it’s not really easy to predict their direction, but give the trading over the weekend a go, as every experience counts.

Types of binary options:
    • High-low: The most popular type of trading, where the trader speculates whether the asset price will increase or decrease over a certain time period (until it expires).
    • One touch: The trader speculates whether the asset price will reach a certain price over the course of the open trade – before it’s expiration. It doesn’t have to end up at this price, which makes the trade a bit easier
    • No touch: This binary option trade is quite similar to the previous one. A trader speculates whether during a certain time (the expiration period) the price won’t reach or go over a given limit.
    • Ladder: Traders speculate whether the price of an underlying asset, at its expiration date, will be higher or lower than the price they’ve set. The potential risk will increase or decrease, depending on the difference between the price over the time of the purchase and the determined expiration time. This usually makes the profit fluctuate, too. You can get a profit of between 1 and 500%
"""
        ),
        Guide(
            id = 11,
            image = R.drawable.guide12,
            title = "Types of Binary Options",
            content = """The example above is for a typical high-low binary option—the most common type of binary option—outside the U.S. International brokers will typically offer several other types of binaries as well.

One-Touch
These include "one-touch" options, where the traded instrument needs to touch the strike price just once before expiration to make money. There is a target above and below the current price, so traders can pick which target they believe will be hit before the expiration date/time.

Range
Meanwhile, a "range" binary option allows traders to select a price range the asset will trade within until expiration. A payout is received if the price stays within the range, while the investment is lost if it exits the range.

Others
As competition in the binary options space heats up, brokers are offering additional products that boast 50% to 500% payouts. While product structures and requirements may change, the risk and reward are always known at the trade's outset, allowing the trader to potentially make more on a position than they lose. Of course, an option offering a 500% payout will be structured in such a way that the probability of winning the payout is very low.

Unlike their U.S. counterparts, some foreign brokers allow traders to exit positions before expiration, but most do not. Exiting a trade before expiration typically results in a lower payout (specified by broker) or small loss, but the trader won't lose their entire investment.
"""
        ),
        Guide(
            id = 12,
            image = R.drawable.guide13,
            title = "Risk and Reward of Binary Options",
            content = """Risk and reward are known in advance, offering a major advantage. There are only two outcomes: win a fixed amount or lose a fixed amount, and there are generally no commissions or fees. They're simple to use and there's only one decision to make: Is the underlying asset going up or down?

In addition, there are also no liquidity concerns because the trader doesn't own the underlying asset and brokers can offer innumerable strike prices and expiration times/dates, which is an attractive feature. The trader can also access multiple asset classes anytime a market is open somewhere in the world.

On the downside, the reward is always less than the risk when playing high-low binary options. As a result, the trader must be right a high percentage of the time to cover inevitable losses.

While payout and risk fluctuate from broker to broker and instrument to instrument, one thing remains constant: Losing trades cost the trader more than they can make on winning trades. Other types of binary options may provide payouts where the reward is potentially greater than the risk but the percentage of winning trades will be lower.

Finally, OTC markets are unregulated outside the U.S. and there is little government oversight in the case of a trade discrepancy. While brokers often use external sources for quotes, traders may still find themselves susceptible to unscrupulous practices.
"""
        ),
        Guide(
            id = 13,
            image = R.drawable.guide14,
            title = "What Is an Option?",
            content = """The term option refers to a financial instrument that is based on the value of underlying securities such as stocks. An options contract offers the buyer the opportunity to buy or sell—depending on the type of contract they hold—the underlying asset. Unlike futures, the holder is not required to buy or sell the asset if they decide against it. Each contract will have a specific expiration date by which the holder must exercise their option. The stated price on an option is known as the strike price. Options are typically bought and sold through online or retail brokers.


Understanding Options

Options are versatile financial products. These contracts involve a buyer and seller, where the buyer pays a premium for the rights granted by the contract. Call options allow the holder to buy the asset at a stated price within a specific timeframe. Put options, on the other hand, allow the holder to sell the asset at a stated price within a specific timeframe. Each call option has a bullish buyer and a bearish seller while put options have a bearish buyer and a bullish seller.

Traders and investors buy and sell options for several reasons. Options speculation allows a trader to hold a leveraged position in an asset at a lower cost than buying shares of the asset. Investors use options to hedge or reduce the risk exposure of their portfolios.

In some cases, the option holder can generate income when they buy call options or become an options writer. Options are also one of the most direct ways to invest in oil. For options traders, an option's daily trading volume and open interest are the two key numbers to watch in order to make the most well-informed investment decisions.

American options can be exercised any time before the expiration date of the option, while European options can only be exercised on the expiration date or the exercise date. Exercising means utilizing the right to buy or sell the underlying security.


Special Considerations

Options contracts usually represent 100 shares of the underlying security. The buyer pays a premium fee for each contract. For example, if an option has a premium of 35 cents per contract, buying one option costs ${'$'}35 (${'$'}0.35 x 100 = ${'$'}35). The premium is partially based on the strike price or the price for buying or selling the security until the expiration date.

Another factor in the premium price is the expiration date. Just like with that carton of milk in the refrigerator, the expiration date indicates the day the option contract must be used. The underlying asset will determine the use-by date. For stocks, it is usually the third Friday of the contract's month.


Options Spreads

Options spreads are strategies that use various combinations of buying and selling different options for the desired risk-return profile. Spreads are constructed using vanilla options, and can take advantage of various scenarios such as high- or low-volatility environments, up- or down-moves, or anything in-between.
"""
        ),
        Guide(
            id = 14,
            image = R.drawable.guide15,
            title = "Advantages and Disadvantages of Options",
            content = """Buying Call Options

As mentioned earlier, call options allow the holder to buy an underlying security at the stated strike price by the expiration date called the expiry. The holder has no obligation to buy the asset if they do not want to purchase the asset. The risk to the buyer is limited to the premium paid. Fluctuations of the underlying stock have no impact.

Buyers are bullish on a stock and believe the share price will rise above the strike price before the option expires. If the investor's bullish outlook is realized and the price increases above the strike price, the investor can exercise the option, buy the stock at the strike price, and immediately sell the stock at the current market price for a profit.

Their profit on this trade is the market share price less the strike share price plus the expense of the option—the premium and any brokerage commission to place the orders. The result is multiplied by the number of option contracts purchased, then multiplied by 100—assuming each contract represents 100 shares.

If the underlying stock price does not move above the strike price by the expiration date, the option expires worthlessly. The holder is not required to buy the shares but will lose the premium paid for the call.


Selling Call Options

Selling call options is known as writing a contract. The writer receives the premium fee. In other words, a buyer pays the premium to the writer (or seller) of an option. The maximum profit is the premium received when selling the option. An investor who sells a call option is bearish and believes the underlying stock's price will fall or remain relatively close to the option's strike price during the life of the option.

If the prevailing market share price is at or below the strike price by expiry, the option expires worthlessly for the call buyer. The option seller pockets the premium as their profit. The option is not exercised because the buyer would not buy the stock at the strike price higher than or equal to the prevailing market price.

However, if the market share price is more than the strike price at expiry, the seller of the option must sell the shares to an option buyer at that lower strike price. In other words, the seller must either sell shares from their portfolio holdings or buy the stock at the prevailing market price to sell to the call option buyer. The contract writer incurs a loss. How large of a loss depends on the cost basis of the shares they must use to cover the option order, plus any brokerage order expenses, but less any premium they received.

As you can see, the risk to the call writers is far greater than the risk exposure of call buyers. The call buyer only loses the premium. The writer faces infinite risk because the stock price could continue to rise increasing losses significantly.


Buying Put Options

Put options are investments where the buyer believes the underlying stock's market price will fall below the strike price on or before the expiration date of the option. Once again, the holder can sell shares without the obligation to sell at the stated strike per share price by the stated date.

Since buyers of put options want the stock price to decrease, the put option is profitable when the underlying stock's price is below the strike price. If the prevailing market price is less than the strike price at expiry, the investor can exercise the put. They will sell shares at the option's higher strike price. Should they wish to replace their holding of these shares they may buy them on the open market.

Their profit on this trade is the strike price less the current market price, plus expenses—the premium and any brokerage commission to place the orders. The result would be multiplied by the number of option contracts purchased, then multiplied by 100—assuming each contract represents 100 shares.

The value of holding a put option will increase as the underlying stock price decreases. Conversely, the value of the put option declines as the stock price increases. The risk of buying put options is limited to the loss of the premium if the option expires worthlessly.


Selling Put Options

Selling put options is also known as writing a contract. A put option writer believes the underlying stock's price will stay the same or increase over the life of the option, making them bullish on the shares. Here, the option buyer has the right to make the seller, buy shares of the underlying asset at the strike price on expiry.

If the underlying stock's price closes above the strike price by the expiration date, the put option expires worthlessly. The writer's maximum profit is the premium. The option isn't exercised because the option buyer would not sell the stock at the lower strike share price when the market price is more.

If the stock's market value falls below the option strike price, the writer is obligated to buy shares of the underlying stock at the strike price. In other words, the put option will be exercised by the option buyer who sells their shares at the strike price as it is higher than the stock's market value.

The risk for the put option writer happens when the market's price falls below the strike price. The seller is forced to purchase shares at the strike price at expiration. The writer's loss can be significant depending on how much the shares depreciate.

The writer (or seller) can either hold on to the shares and hope the stock price rises back above the purchase price or sell the shares and take the loss. Any loss is offset by the premium received.

An investor may write put options at a strike price where they see the shares being a good value and would be willing to buy at that price. When the price falls and the buyer exercises their option, they get the stock at the price they want with the added benefit of receiving the option premium.
"""
        )
    ),
    var pairs: List<CurrencyPair> = listOf(
        CurrencyPair(
            "EUR/USD",
            R.drawable.eur,
            R.drawable.usd,
            Math.floor((Random(Date().time).nextDouble(0.6, 1.5)) * 1000.0) / 1000.0,
            prev_price = 1.0
        ),
        CurrencyPair(
            "AUD/USD",
            R.drawable.aud,
            R.drawable.usd,
            Math.floor((Random(Date().time).nextDouble(0.6, 1.5)) * 1000.0) / 1000.0,
            prev_price = 1.0
        ),
        CurrencyPair(
            "GBR/USD",
            R.drawable.uk,
            R.drawable.usd,
            Math.floor((Random(Date().time).nextDouble(0.6, 1.5)) * 1000.0) / 1000.0,
            prev_price = 1.0
        ),
        CurrencyPair(
            "USD/JPY",
            R.drawable.usd,
            R.drawable.jpy,
            Math.floor((Random(Date().time).nextDouble(0.6, 1.5)) * 1000.0) / 1000.0,
            prev_price = 1.0
        ),
        CurrencyPair(
            "USD/CAD",
            R.drawable.usd,
            R.drawable.cad,
            Math.floor((Random(Date().time).nextDouble(0.6, 1.5)) * 1000.0) / 1000.0,
            prev_price = 1.0
        ),


        )
)
