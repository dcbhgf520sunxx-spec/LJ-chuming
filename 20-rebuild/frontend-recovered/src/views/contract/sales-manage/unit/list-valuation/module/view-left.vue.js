import { ref as n } from "vue";
import U from "moment";
import { inject as B } from "vue";
import { watch as D } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as K } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as f } from "vue";
import { withKeys as A } from "vue";
import { withDirectives as H } from "vue";
import { createBlock as g } from "vue";
import { withCtx as w } from "vue";
import { toDisplayString as V } from "vue";
import { unref as x } from "vue";
import { createTextVNode as O } from "vue";
import { createCommentVNode as P } from "vue";
import { normalizeStyle as z } from "vue";
import { ElDatePicker as q } from "element-plus";
import { ElInput as F } from "element-plus";
import { ElTag as Q } from "element-plus";
import { ElTree as Y } from "element-plus";
import { vLoading as $ } from "element-plus";
import { g as G } from "../../../../../../modules/list-valuation-9a754659.js";
import { _ as J, n as W, z as X, kR as E } from "../../../../../../shared/runtime.js";
const Z = { class: "wrap-left" }, ee = { class: "left-header" }, te = { style: { padding: "3px 0px", "border-radius": "3px", width: "100%", "line-height": "18px" }, class: "flex-rbc" }, ae = { style: { "font-weight": "bold", flex: "1", "white-space": "normal", "min-width": "0" } }, oe = { __name: "view-left", props: { maxHeight: { type: Number, default: 500 } }, emits: ["project-change"], setup(L, { emit: N }) {
  const r = { SHORT_NAME: { L: "项目简称", K: "SHORT_NAME", V: 1, field: "shortName" }, SERIAL_NUMBER: { L: "项目编号", K: "SERIAL_NUMBER", V: 2, field: "serialNumber" }, FULL: { L: "项目编号+简称", K: "FULL", V: 3, field: "fullname" } };
  W(r);
  const b = { children: "children", label: "name" }, _ = N, h = n(), a = n({ year: U().startOf("year").valueOf() }), u = n(false), v = n([]), s = n(), m = n(r.SHORT_NAME.V), y = B("crud");
  D(() => a.value.year, (e) => {
    y.query.year = e, y.toQuery();
  }, { immediate: true }), i();
  function k(e) {
    return e > /* @__PURE__ */ new Date();
  }
  async function i() {
    try {
      let e = false;
      u.value = true;
      const { content: t } = await G({ dateTime: a.value.year, name: a.value.name });
      v.value = t.map((o) => (o.fullname = X(o), o.id === s.value && (e = true), o)), e || _("project-change", void 0);
    } catch (e) {
      console.log(e);
    } finally {
      u.value = false;
    }
  }
  function j(e) {
    s.value === e.id ? (h.value.setCurrentKey(), s.value = void 0) : s.value = e.id, _("project-change", s.value);
  }
  return (e, t) => {
    const o = q, S = F, R = I("common-radio-button"), C = Q, M = Y, T = $;
    return p(), K("div", Z, [d("div", ee, [f(o, { modelValue: a.value.year, "onUpdate:modelValue": t[0] || (t[0] = (l) => a.value.year = l), type: "year", style: { width: "100px" }, placeholder: "选择年", class: "filter-item", "value-format": "x", clearable: "", "disabled-date": k, onChange: i }, null, 8, ["modelValue"]), f(S, { modelValue: a.value.name, "onUpdate:modelValue": t[1] || (t[1] = (l) => a.value.name = l), placeholder: "请输入名称/编号搜索", class: "filter-item", style: { width: "230px" }, clearable: "", onKeyup: A(i, ["enter"]), onChange: i }, null, 8, ["modelValue"]), f(R, { modelValue: m.value, "onUpdate:modelValue": t[2] || (t[2] = (l) => m.value = l), options: r.ENUM, class: "filter-item", size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), d("div", { style: z(`height: ${L.maxHeight + 56}px; overflow: auto;`) }, [H((p(), g(M, { ref_key: "treeMenuRef", ref: h, data: v.value, props: b, "highlight-current": "", "expand-on-click-node": false, "node-key": "id", onNodeClick: j }, { default: w(({ node: l, data: c }) => [d("div", te, [d("span", ae, V(c[r.V[m.value].field]), 1), c.pricingStatusEnum ? (p(), g(C, { key: 0, type: x(E).V[c.pricingStatusEnum].T, effect: "plain" }, { default: w(() => [O(V(x(E).VL[c.pricingStatusEnum]), 1)]), _: 2 }, 1032, ["type"])) : P("", true)])]), _: 1 }, 8, ["data"])), [[T, u.value]])], 4)]);
  };
} }, ie = J(oe, [["__scopeId", "data-v-6ec70efd"]]);
export {
  ie as default
};
