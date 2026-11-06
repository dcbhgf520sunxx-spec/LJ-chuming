import { openBlock as o } from "vue";
import { createElementBlock as s } from "vue";
import { createVNode as t } from "vue";
import { withCtx as a } from "vue";
import { createTextVNode as n } from "vue";
import { unref as _ } from "vue";
import { ElTag as l } from "element-plus";
import { E as c } from "../../../../../../shared/runtime.js";
const m = { __name: "header", setup(p) {
  return (u, e) => {
    const r = l;
    return o(), s("div", null, [t(_(c), null, { viewLeft: a(() => [t(r, { size: "large" }, { default: a(() => e[0] || (e[0] = [n("双击表格中的“行”，可更改表格默认模板")])), _: 1, __: [0] })]), _: 1 })]);
  };
} };
export {
  m as default
};
