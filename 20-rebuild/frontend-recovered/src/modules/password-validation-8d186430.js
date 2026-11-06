import { af as n } from "../shared/runtime.js";
const a = "0123456789", g = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", c = "!@#$%^&*()_+-=[]{}|;:,.<>?";
function R(e, s, o) {
  if (!e) return "请输入密码";
  if (e.length < o) return `密码长度至少为 ${o} 位`;
  let r = "";
  const i = [];
  if (s.includes(n.NUMBER.V) && (r += a, i.push("数字")), s.includes(n.LETTER.V) && (r += g, i.push("字母")), s.includes(n.SPECIAL_CHARACTERS.V) && (r += c, i.push(`特殊字符（${c}）`)), !r) return "至少选择一种密码组成规则";
  const t = [];
  if (s.includes(n.NUMBER.V) && (new RegExp(`[${a.replace(/[-[\]{}()*+?.,\\^$|#\s]/g, "\\$&")}]`).test(e) || t.push("数字")), s.includes(n.LETTER.V) && (new RegExp(`[${g.replace(/[-[\]{}()*+?.,\\^$|#\s]/g, "\\$&")}]`).test(e) || t.push("字母")), s.includes(n.SPECIAL_CHARACTERS.V) && (new RegExp(`[${c.replace(/[-[\]{}()*+?.,\\^$|#\s]/g, "\\$&")}]`).test(e) || t.push(`特殊字符（${c}）`)), t.length > 0) return `密码必须包含${t.join("、")}`;
  const $ = r.replace(/[-[\]{}()*+?.,\\^$|#\s]/g, "\\$&");
  return new RegExp(`^[${$}]+$`).test(e) ? null : `密码只能由${i.join("、")}组成`;
}
export {
  g as l,
  a as n,
  c as s,
  R as v
};
