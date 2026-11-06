import { G as i, fe as c, E as d } from "../../../../../shared/runtime.js";
import { resolveComponent as p } from "vue";
import { openBlock as o } from "vue";
import { createBlock as s } from "vue";
import { withCtx as n } from "vue";
import { unref as t } from "vue";
import { createTextVNode as u } from "vue";
import { createCommentVNode as _ } from "vue";
const b = { __name: "header", emits: ["toEdit"], setup(f, { emit: a }) {
  const r = a;
  return (l, e) => {
    const m = p("common-button");
    return o(), s(t(d), { addText: "创建" }, { viewLeft: n(() => [t(i)(t(c).edit) ? (o(), s(m, { key: 0, type: "success", size: "default", onClick: e[0] || (e[0] = (k) => r("toEdit")) }, { default: n(() => e[1] || (e[1] = [u("修改")])), _: 1, __: [1] })) : _("", true)]), _: 1 });
  };
} };
export {
  b as default
};
