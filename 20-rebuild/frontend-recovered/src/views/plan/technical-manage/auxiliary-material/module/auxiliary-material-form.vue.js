import { ref as c } from "vue";
import { provide as P } from "vue";
import { inject as _ } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as U } from "vue";
import { createElementBlock as $ } from "vue";
import { createVNode as l } from "vue";
import { withCtx as f } from "vue";
import { createElementVNode as I } from "vue";
import { createTextVNode as q } from "vue";
import { unref as a } from "vue";
import { reactive as z } from "vue";
import { watch as H } from "vue";
import { nextTick as B } from "vue";
import { ElForm as D } from "element-plus";
import { l as L, _ as Q, am as W, tB as G, o as M, cQ as J } from "../../../../../shared/runtime.js";
import X from "./material/common-wrapper.vue.js";
import Y from "./material/aux-mat-table.vue.js";
import "../../../../wms/material-inbound/raw-material/application/components/common-footer.vue.js";
import "./material/confirm-dialog.vue.js";
function Z(r) {
  return L({ module: "plan", url: "auxiliaryMaterial/save", method: "post", params: { projectId: r.projectId, monomerId: r.monomerId }, data: r.list });
}
const ee = { class: "aux-mat-inbound-application-container" }, te = { class: "filter-container" }, ae = { class: "filter-left-box" }, oe = { __name: "auxiliary-material-form", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success"], setup(r, { emit: R }) {
  const S = R, b = r, V = { projectId: null, monomerId: null, list: [] }, s = c(), t = c(), x = c(), v = c(), m = c(false), g = W.MATERIAL.V;
  P("matSpecRef", t);
  const k = _("currentMonomer"), j = _("currentArea"), C = _("globalProject"), F = (i) => {
    i.list = i.list.map((n) => z(n));
    const e = H(s, (n) => {
      if (n) {
        const p = H(t, () => {
          t.value && (t.value.initSelected(i.list.map((u) => ({ sn: u.sn, classifyId: u.classifyId }))), B(() => {
            p();
          }));
        }, { immediate: true });
        B(() => {
          e();
        });
      }
    }, { immediate: true, deep: true });
    T();
  }, { form: o, FORM: h } = G({ title: "配套件清单", defaultForm: V, useDraftCallback: F, api: Z }, x, b.detail), { maxHeight: A } = M({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => v.value.loaded), O = { mainBox: ".aux-mat-inbound-application-container", extraBox: [".filter-container", ".inbound-application-header", ".inbound-application-footer"], navbar: true, minHeight: 300, extraHeight: 20 }, { fixMaxHeight: T, maxHeight: E } = M(O);
  w(), h.HOOK.afterSubmit = () => {
    S("success"), w();
  }, h.HOOK.beforeSubmit = () => {
    o.projectId = C.value.id, o.monomerId = k.value.id, o.areaId = j.value.id;
  };
  function N() {
    return s.value ? s.value.validate() : true;
  }
  function K(i) {
    return s.value.rowInit(i);
  }
  function w() {
    t.value && t.value.clear();
  }
  return (i, e) => {
    const n = y("common-button"), p = D, u = y("common-drawer");
    return U(), $("div", ee, [l(X, { "basic-class": a(g), validate: N, edit: b.edit, "show-total": false }, { default: f(() => [I("div", te, [I("div", ae, [l(n, { class: "filter-item", type: "success", onClick: e[0] || (e[0] = (d) => m.value = true) }, { default: f(() => e[3] || (e[3] = [q(" 添加物料 ")])), _: 1, __: [3] })])]), l(p, { ref_key: "formRef", ref: x, model: a(o) }, { default: f(() => [l(Y, { ref_key: "tableRef", ref: s, "max-height": a(E) }, null, 8, ["max-height"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["basic-class", "edit"]), l(u, { ref_key: "drawerRef", ref: v, modelValue: m.value, "onUpdate:modelValue": e[2] || (e[2] = (d) => m.value = d), title: "物料选择", "show-close": true, size: 900, "custom-class": "material-table-spec-select" }, { content: f(() => [l(J, { ref_key: "matSpecRef", ref: t, modelValue: a(o).list, "onUpdate:modelValue": e[1] || (e[1] = (d) => a(o).list = d), visible: m.value, "row-init-fn": K, "max-height": a(A), "basic-class": a(g), "table-width": 430, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "visible", "max-height", "basic-class"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, me = Q(oe, [["__scopeId", "data-v-f2bc0b82"]]);
export {
  me as default
};
