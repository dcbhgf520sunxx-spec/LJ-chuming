import { dC as f, u as I, dA as r, G as O, L as T, R as N, S as k } from "../../../../../shared/runtime.js";
import { u as x, f as L } from "../../../../../modules/use-form-config-data-098a0552.js";
import M from "../../../components/information-description/index.vue.js";
import { ref as B } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as y } from "vue";
import { createBlock as C } from "vue";
import { withCtx as m } from "vue";
import { unref as o } from "vue";
import { createTextVNode as G } from "vue";
import { createCommentVNode as U } from "vue";
import { createElementVNode as j } from "vue";
import { createVNode as u } from "vue";
import { isRef as z } from "vue";
import "../../../../../modules/project-information-053c195b.js";
const A = { class: "head-container" }, J = { __name: "detail", props: { modelValue: { type: Boolean, default: void 0 }, currentRow: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(c, { emit: V }) {
  const s = B(f.DOMESTIC.V), l = c, _ = V, { visible: i, handleClose: D } = I({ emit: _, props: l, showHook: w }), { fetchFormItemList: R, fetchFormDetail: g, formItemList: d, serchFormDetail: a } = x();
  async function w() {
    var t, e;
    await h(), (t = a.value) != null && t.crmCountryTypeEnum && (s.value = (e = a.value) == null ? void 0 : e.crmCountryTypeEnum), await b();
  }
  async function h() {
    try {
      await g({ pageEnum: r.FIRM_RECORD_CONFIG.V, params: l.currentRow }), console.log(a.value, "serchFormDetail");
    } catch (t) {
      console.log(t);
    }
  }
  async function b() {
    try {
      console.log(r.FIRM_RECORD_CONFIG.V), await R({ pageEnum: r.FIRM_RECORD_CONFIG.V, countryType: s.value }), console.log(d.value);
    } catch (t) {
      console.log(t);
    }
  }
  function v(t) {
    s.value = t;
  }
  return (t, e) => {
    const E = p("common-radio-button"), F = p("common-drawer");
    return y(), C(F, { modelValue: o(i), "onUpdate:modelValue": e[2] || (e[2] = (n) => z(i) ? i.value = n : null), "before-close": o(D), size: "100%", "close-on-click-modal": false, title: "企业详情" }, { titleRight: m(() => [o(O)(c.permission.export) ? (y(), C(T, { key: 0, fn: o(L), params: { id: l.currentRow.id }, size: "default" }, { default: m(() => e[3] || (e[3] = [G(" 下载 ")])), _: 1, __: [3] }, 8, ["fn", "params"])) : U("", true)]), content: m(() => [j("div", A, [u(E, { modelValue: s.value, "onUpdate:modelValue": e[0] || (e[0] = (n) => s.value = n), options: o(f).ENUM, class: "filter-item", size: "default", type: "enum", disabled: "", onChange: v }, null, 8, ["modelValue", "options"])]), u(o(M), { "descriptions-list": o(d), "form-detail": o(a), style: { "margin-bottom": "10px" } }, null, 8, ["descriptions-list", "form-detail"]), u(N, { showView: "", "show-download": "", files: o(a).attachmentDTOList, "onUpdate:files": e[1] || (e[1] = (n) => o(a).attachmentDTOList = n), "file-classify": o(k).RECORD_ATT.V, disabled: true, delDisabled: true }, null, 8, ["files", "file-classify"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  J as default
};
