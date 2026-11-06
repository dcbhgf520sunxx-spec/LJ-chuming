import { useStore as X } from "vuex";
import { ref as u } from "vue";
import { provide as q } from "vue";
import { watch as E } from "vue";
import { computed as N } from "vue";
import { watchEffect as Z } from "vue";
import { nextTick as ee } from "vue";
import { resolveComponent as H } from "vue";
import { openBlock as te } from "vue";
import { createElementBlock as ae } from "vue";
import { createVNode as l } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as x } from "vue";
import { createTextVNode as k } from "vue";
import { unref as n } from "vue";
import { ElMessage as v } from "element-plus";
import { ElForm as ie } from "element-plus";
import { _ as se, am as ne, tB as le, w1 as C, o as M, i as g, wc as O, wo as oe, vv as re, L as ue, vw as ce, vx as me, cQ as fe, b as de } from "../../../../../../shared/runtime.js";
import { s as pe } from "../../../../../../modules/other-e93f8d3e.js";
import ve from "../components/common-wrapper.vue.js";
import ye from "../auxiliary-material/module/aux-mat-table.vue.js";
import _e from "../components/inventory-drawer.vue.js";
import "../components/common-footer.vue.js";
import "../components/confirm-dialog.vue.js";
const be = { class: "aux-mat-requisitions-application-container" }, Ie = { class: "filter-container" }, he = { class: "filter-right-box" }, xe = { class: "filter-item" }, ge = { __name: "index", props: { detail: { type: Object }, isEdit: { type: Boolean, default: false }, isTsData: { type: Boolean, default: false } }, emits: ["success"], setup(w, { expose: U, emit: D }) {
  X();
  const F = D, y = w, z = { list: [], originInventoryInfo: {} }, m = u(), c = u(), S = u(), T = u(), _ = u(false), R = u({}), o = u(), p = u(false), b = ne.GAS.V, V = u({});
  q("useInventoryInfo", V), q("matSpecRef", c);
  const { cu: r, form: a, FORM: Q } = le({ title: "气体申购", defaultForm: z, clearDraftCallback: I, api: y.isEdit ? C.edit : C.add }, S, y.detail);
  E(() => y.detail, (t = {}) => {
    a.materialType = t.materialType, a.branchCompanyId = t.branchCompanyId, a.level = t.level;
  }, { deep: true, immediate: true });
  const { maxHeight: j } = M({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => T.value.loaded), { maxHeight: A } = M({ mainBox: ".requisitions-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".requisitions-application-header", ".requisitions-application-select", ".requisitions-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 200 }), G = N(() => {
    var i;
    let t = [], e = [];
    return g(a.list) && (t = JSON.parse(JSON.stringify(a.list)), e = (i = Array.from(new Set(t == null ? void 0 : t.map((s) => s.classifyId)))) == null ? void 0 : i.map((s) => t == null ? void 0 : t.find((h) => h.classifyId === s))), e.length;
  }), B = N(() => {
    var t;
    return (t = a.list) == null ? void 0 : t.filter((e) => {
      var i, s;
      return (s = (i = r == null ? void 0 : r.submitResult) == null ? void 0 : i.data) == null ? void 0 : s.includes(e.classifyId);
    });
  });
  I(), Z(() => {
    var t;
    if ((t = a.list) != null && t.length) {
      const e = {};
      for (let i = 0; i < a.list.length; i++) {
        const s = a.list[i];
        s.requisitionMode === O.USE_INVENTORY.V && (e[s.materialInventoryId] ? e[s.materialInventoryId] += s.quantity : e[s.materialInventoryId] = s.quantity);
      }
      V.value = e;
    }
  }), Q.HOOK.afterSubmit = () => {
    F("success"), I();
  };
  function J(t, e) {
    R.value = t, o.value = e, _.value = true;
  }
  function L(t, e) {
    const i = e.id;
    a.originInventoryInfo || (a.originInventoryInfo = {}), a.originInventoryInfo[i] = { quantity: e.quantity, frozenQuantity: e.frozenQuantity }, a.list[o.value].quantity = t, a.list[o.value].canUseQuantity = e.quantity, a.list[o.value].color = e.color, a.list[o.value].brand = e.brand, a.list[o.value].unitNet = e.unitNet, a.list[o.value].mete = e.quantity * e.unitNet, a.list[o.value].requisitionMode = O.USE_INVENTORY.V, a.list[o.value].materialInventoryId = i;
  }
  function Y() {
    return de(a.branchCompanyId) ? (v.warning("请选择申购单位"), false) : g(B.value) ? (v.error("请先删除标红数据并重新添加"), false) : m.value ? m.value.validate() : true;
  }
  function $() {
    return m.value ? m.value.TSValidate() : true;
  }
  function K(t) {
    return m.value.rowInit(t);
  }
  function I() {
    c.value && c.value.clear();
  }
  function W() {
    if (g(B.value)) return v.error("请先删除标红数据并重新添加"), false;
    p.value = true;
  }
  function P(t) {
    var e;
    try {
      (e = r == null ? void 0 : r.submitResult) != null && e.data && (r.submitResult.data = null), r.props.import(t);
    } catch (i) {
      v.error({ message: i.message, duration: 5e3 });
    }
  }
  return r.props.import = (t) => {
    a.list.push.apply(a.list, t);
    const e = E(c, () => {
      c.value && (c.value.initSelected(t.map((i) => ({ sn: i.sn, classifyId: i.classifyId }))), ee(() => {
        e();
      }));
    }, { immediate: true });
  }, U({ form: a, TSValidateTable: $ }), (t, e) => {
    const i = H("common-button"), s = ie, h = H("common-drawer");
    return te(), ae("div", be, [l(ve, { "basic-class": n(b), isTsData: w.isTsData, "show-total": false, validate: Y }, { default: d(() => [x("div", Ie, [x("div", he, [x("div", xe, [l(oe, { "right-label": G.value, "show-unit": "" }, null, 8, ["right-label"])]), l(i, { class: "filter-item", type: "success", onClick: W }, { default: d(() => e[3] || (e[3] = [k(" 添加物料 ")])), _: 1, __: [3] }), l(re, { template: n(pe), "btn-name": "清单导入", "btn-size": "default", "btn-type": "warning", class: "filter-item", icon: "el-icon-upload2", "open-loading": "", onSuccess: P }, null, 8, ["template"]), l(ue, { fn: n(ce), params: { basicClass: n(b), receiptType: n(me).REQUISITIONS.V }, class: "filter-item", size: "default", type: "info" }, { default: d(() => e[4] || (e[4] = [k(" 气体清单模板下载 ")])), _: 1, __: [4] }, 8, ["fn", "params"])])]), l(s, { ref_key: "formRef", ref: S, model: n(a) }, { default: d(() => [l(ye, { ref_key: "tableRef", ref: m, "max-height": n(A), onSearchInventory: J }, null, 8, ["max-height"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["basic-class", "isTsData"]), l(h, { ref_key: "drawerRef", ref: T, modelValue: p.value, "onUpdate:modelValue": e[1] || (e[1] = (f) => p.value = f), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: d(() => [l(fe, { ref_key: "matSpecRef", ref: c, modelValue: n(a).list, "onUpdate:modelValue": e[0] || (e[0] = (f) => n(a).list = f), "basic-class": n(b), "max-height": n(j), "row-init-fn": K, "table-width": 430, visible: p.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "max-height", "visible"])]), _: 1 }, 8, ["modelValue"]), l(n(_e), { visible: _.value, "onUpdate:visible": e[2] || (e[2] = (f) => _.value = f), params: R.value, onUseInventory: L }, null, 8, ["visible", "params"])]);
  };
} }, Ne = se(ge, [["__scopeId", "data-v-b1049299"]]);
export {
  Ne as default
};
