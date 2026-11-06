import { openBlock as o } from "vue";
import { createElementBlock as s } from "vue";
import { createVNode as a } from "vue";
import { withCtx as r } from "vue";
import { createTextVNode as n } from "vue";
import { ElTag as _ } from "element-plus";
import { _ as c } from "../../shared/runtime.js";
const d = {}, i = { style: { margin: "20px" } };
function l(f, e) {
  const t = _;
  return o(), s("div", i, [a(t, { size: "large" }, { default: r(() => e[0] || (e[0] = [n(" 当前系统菜单都是外部链接, 请点击上方菜单进行跳转 ")])), _: 1, __: [0] })]);
}
const x = c(d, [["render", l]]);
export {
  x as default
};
