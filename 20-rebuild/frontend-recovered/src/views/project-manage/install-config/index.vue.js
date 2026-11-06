import { openBlock as s } from "vue";
import { createElementBlock as i } from "vue";
import { unref as t } from "vue";
import { createBlock as m } from "vue";
import { withCtx as o } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as d } from "vue";
import { ElCol as u } from "element-plus";
import { ElRow as g } from "element-plus";
import { ElTag as f } from "element-plus";
import { m as b, i as x, bN as y } from "../../../shared/runtime.js";
import k from "./module/auxiliary-config.vue.js";
import j from "./module/project.vue.js";
import "../../../modules/install-config-0f2e817e.js";
import "../../../modules/project-19a12d6b.js";
const N = { class: "app-container" }, T = { key: 1 }, A = { __name: "index", setup(E) {
  const { globalProject: a } = b(["globalProject"]);
  return (B, n) => {
    var l, c;
    const r = u, p = g, _ = f;
    return s(), i("div", N, [t(x)((l = t(a)) == null ? void 0 : l.installReportMethod) && ((c = t(a)) == null ? void 0 : c.businessType) === t(y).INSTALLATION.V ? (s(), m(p, { key: 0, gutter: 40 }, { default: o(() => [e(r, { span: 8 }, { default: o(() => [e(t(k))]), _: 1 }), e(r, { span: 10 }, { default: o(() => [e(t(j), { style: { "margin-bottom": "20px" }, globalProject: t(a) }, null, 8, ["globalProject"])]), _: 1 })]), _: 1 })) : (s(), i("div", T, [e(_, { type: "danger", size: "large", style: { "margin-bottom": "10px" } }, { default: o(() => n[0] || (n[0] = [d(" * 您好，请先选择业务类型为项目承包的项目，当前页面需要选择业务类型为项目承包方可查看 ")])), _: 1, __: [0] })]))]);
  };
} };
export {
  A as default
};
