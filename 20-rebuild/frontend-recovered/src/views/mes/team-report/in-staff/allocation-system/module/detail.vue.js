import { ref as y } from "vue";
import { watch as I } from "vue";
import { inject as M } from "vue";
import { resolveComponent as j } from "vue";
import { resolveDirective as O } from "vue";
import { openBlock as D } from "vue";
import { createBlock as R } from "vue";
import { withCtx as t } from "vue";
import { createVNode as i } from "vue";
import { createElementVNode as a } from "vue";
import { toDisplayString as c } from "vue";
import { unref as o } from "vue";
import { createTextVNode as B } from "vue";
import { withDirectives as h } from "vue";
import { isRef as T } from "vue";
import { ElTag as $ } from "element-plus";
import { ElTableColumn as S } from "element-plus";
import { vLoading as A } from "element-plus";
import { l as L, u as E, o as P } from "../../../../../../shared/runtime.js";
import { _ as U } from "../../../../../../modules/index-3b2628f3.js";
function F(l) {
  return L({ module: "mes", url: "wages/in_staff/distribution", method: "get", params: l });
}
function G(l) {
  return L({ module: "mes", url: "wages/in_staff/distribution/complete", method: "get", params: l });
}
const X = { get: F }, J = { __name: "detail", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(l, { emit: N }) {
  const x = y(), C = N, r = l, { visible: v, handleClose: q } = E({ emit: C, props: r, field: "visible" }), { maxHeight: z } = P({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, x);
  I(() => r.visible, (d) => {
    d && H();
  }, { immediate: true });
  const g = y(false), k = y([]), u = M("query");
  async function H() {
    var e, m, n, p, _, f;
    let d = [];
    try {
      g.value = true;
      const b = Object.assign({ factoryId: (m = (e = r.info) == null ? void 0 : e.factory) == null ? void 0 : m.id, productionLineId: (p = (n = r.info) == null ? void 0 : n.productionLine) == null ? void 0 : p.id, workshopId: (f = (_ = r.info) == null ? void 0 : _.workshop) == null ? void 0 : f.id }, u), { content: w } = await G(b);
      d = w;
    } catch {
      console.log("获取处理列表失败");
    } finally {
      k.value = d, g.value = false;
    }
  }
  return (d, e) => {
    var w, V;
    const m = $, n = S, p = j("common-table"), _ = j("common-drawer"), f = O("parse-time"), b = A;
    return D(), R(_, { ref_key: "drawerRef", ref: x, title: `${(w = l.info.workshop) == null ? void 0 : w.name}>${(V = l.info.productionLine) == null ? void 0 : V.name}`, modelValue: o(v), "onUpdate:modelValue": e[0] || (e[0] = (s) => T(v) ? v.value = s : null), direction: "rtl", "before-close": o(q), size: "60%" }, { titleAfter: t(() => [i(m, { effect: "plain", size: "large" }, { default: t(() => [e[1] || (e[1] = a("span", null, "累计生产量：", -1)), a("span", null, c(o(u).startDate) + " 件", 1), e[2] || (e[2] = B(" / ")), a("span", null, c(o(u).endDate), 1)]), _: 1, __: [1, 2] }), i(m, { type: "success", effect: "plain", size: "large" }, { default: t(() => [e[3] || (e[3] = a("span", null, "统计日期：", -1)), h(a("span", null, null, 512), [[f, { val: o(u).startDate, fmt: "{y}-{m}-{d}" }]]), e[4] || (e[4] = B(" ~ ")), h(a("span", null, null, 512), [[f, { val: o(u).endDate, fmt: "{y}-{m}-{d}" }]])]), _: 1, __: [3, 4] })]), titleRight: t(() => e[5] || (e[5] = [])), content: t(() => [h((D(), R(p, { ref: "tableRef", data: k.value, "max-height": o(z), style: { width: "100%" } }, { default: t(() => [i(n, { label: "序号", type: "index", align: "center", width: "60" }), i(o(U), { showProject: "", showMonomer: "" }), i(n, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称" }, { default: t((s) => [a("span", null, c(s.row.name), 1)]), _: 1 }), i(n, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号" }, { default: t((s) => [a("span", null, c(s.row.serialNumber), 1)]), _: 1 }), i(n, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质" }, { default: t((s) => [a("span", null, c(s.row.material), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[b, g.value]])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, Y = Object.freeze(Object.defineProperty({ __proto__: null, default: J }, Symbol.toStringTag, { value: "Module" }));
export {
  J as _,
  X as c,
  Y as d
};
