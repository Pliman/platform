<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>验证银行返回值</title>
		<meta http-equiv="pragma" content="no-cache">
	</head>

	<body>
		<form action="paycallback" method="post">
			<table>
				<tbody>
					<tr>
						<td>
							支付平台交易流水号
						</td>
						<td>
							<input type="text" value="111111111111111111111111111130"
								name="UPTRANSEQ" />
						</td>
					</tr>

					<tr>
						<td>
							支付平台交易日期
						</td>
						<td>
							<input type="text" value="20120114" name="TRANDATE" />
						</td>
					</tr>


					<tr>
						<td>
							处理结果码
						</td>
						<td>
							<input type="text" value="1234" name="RETNCODE" />
						</td>
					</tr>


					<tr>
						<td>
							处理结果解释码
						</td>
						<td>
							<input type="text" value="1234567810" name="RETNINFO" />
						</td>
					</tr>

					<tr>
						<td>
							订单请求交易流水号
						</td>
						<td>
							<input type="text" value="char(32)" name="ORDERREQTRANSEQ" />
						</td>
					</tr>

					<tr>
						<td>
							订单号
						</td>
						<td>
							<input type="text" value="char(32)" name="ORDERSEQ" />
						</td>
					</tr>

					<tr>
						<td>
							订单总金额
						</td>
						<td>
							<input type="text" value="number(10)" name="ORDERAMOUNT" />
						</td>
					</tr>

					<tr>
						<td>
							产品金额
						</td>
						<td>
							<input type="text" value="NUMBER(10)" name="PRODUCTAMOUNT" />
						</td>
					</tr>

					<tr>
						<td>
							附加金额
						</td>
						<td>
							<input type="text" value="NUMBER(10)" name="ATTACHAMOUNT" />
						</td>
					</tr>

					<tr>
						<td>
							币种
						</td>
						<td>
							<input type="text" value="CHAR(10)" name="CURTYPE" />
						</td>
					</tr>

					<tr>
						<td>
							加密方式
						</td>
						<td>
							<input type="text" value="CHAR(1)" name="ENCODETYPE" />
						</td>
					</tr>

					<tr>
						<td>
							SP附加信息
						</td>
						<td>
							<input type="text" value="CHAR(32)" name="ATTACH" />
						</td>
					</tr>

					<tr>
						<td>
							数字签名
						</td>
						<td>
							<input type="text" value="CHAR(256)" name="SIGN" />
						</td>
					</tr>
				</tbody>
			</table>
			<input type="submit" value="确认" />
		</form>
	</body>
</html>
