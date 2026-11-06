import { useStore as ee } from "vuex";
import { ref as u } from "vue";
import { provide as q } from "vue";
import { computed as N } from "vue";
import { watch as H } from "vue";
import { watchEffect as te } from "vue";
import { nextTick as ae } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as ie } from "vue";
import { createElementBlock as se } from "vue";
import { createVNode as o } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as w } from "vue";
import { createTextVNode as C } from "vue";
import { unref as n } from "vue";
import { ElMessage as _ } from "element-plus";
import { ElTooltip as ne } from "element-plus";
import { ElForm as le } from "element-plus";
import { _ as oe, am as re, tB as ue, w1 as M, i as p, o as O, wc as U, wo as ce, vv as me, L as fe, vw as de, vx as pe, cQ as ve, b as ye } from "../../../../../../shared/runtime.js";
import { s as _e } from "../../../../../../modules/other-e93f8d3e.js";
import be from "../components/common-wrapper.vue.js";
import Ie from "../auxiliary-material/module/aux-mat-table.vue.js";
import he from "../components/inventory-drawer.vue.js";
import "../components/common-footer.vue.js";
import "../components/confirm-dialog.vue.js";
const xe = { class: "aux-mat-requisitions-application-container" }, ge = { class: "filter-container" }, we = { class: "filter-right-box" }, Se = { class: "filter-item" }, Te = { __name: "index", props: { detail: { type: Object }, isEdit: { type: Boolean, default: false }, isTsData: { type: Boolean, default: false } }, emits: ["success"], setup(S, { expose: D, emit: F }) {
  ee();
  const z = F, v = S, Q = { list: [], originInventoryInfo: {} }, f = u(), m = u(), T = u(), R = u(), b = u(false), V = u({}), r = u(), y = u(false), I = re.OTHER.V, E = u({});
  q("useInventoryInfo", E), q("matSpecRef", m);
  const { cu: l, form: a, FORM: j } = ue({ title: "其它申购", defaultForm: Q, clearDraftCallback: x, api: v.isEdit ? M.edit : M.add }, T, v.detail), J = N(() => {
    var i;
    let t = [], e = [];
    return p(a.list) && (t = JSON.parse(JSON.stringify(a.list)), e = (i = Array.from(new Set(t == null ? void 0 : t.map((s) => s.classifyId)))) == null ? void 0 : i.map((s) => t == null ? void 0 : t.find((g) => g.classifyId === s))), e.length;
  }), h = N(() => {
    var t;
    return (t = a.list) == null ? void 0 : t.filter((e) => {
      var i, s;
      return (s = (i = l == null ? void 0 : l.submitResult) == null ? void 0 : i.data) == null ? void 0 : s.includes(e.classifyId);
    });
  });
  H(() => v.detail, (t = {}) => {
    a.materialType = t.materialType, a.branchCompanyId = t.branchCompanyId, a.level = t.level;
  }, { deep: true, immediate: true });
  const { maxHeight: L } = O({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => R.value.loaded), { maxHeight: Y } = O({ mainBox: ".requisitions-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".requisitions-application-header", ".requisitions-application-select", ".requisitions-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: v.isTsData ? 0 : 200 });
  x(), te(() => {
    var t;
    if ((t = a.list) != null && t.length) {
      const e = {};
      for (let i = 0; i < a.list.length; i++) {
        const s = a.list[i];
        s.requisitionMode === U.USE_INVENTORY.V && (e[s.materialInventoryId] ? e[s.materialInventoryId] += s.quantity : e[s.materialInventoryId] = s.quantity);
      }
      E.value = e;
    }
  }), j.HOOK.afterSubmit = () => {
    z("success"), x();
  };
  function $(t, e) {
    V.value = t, r.value = e, b.value = true;
  }
  function A(t, e) {
    const i = e.id;
    a.originInventoryInfo || (a.originInventoryInfo = {}), a.originInventoryInfo[i] = { quantity: e.quantity, frozenQuantity: e.frozenQuantity }, a.list[r.value].quantity = t, a.list[r.value].canUseQuantity = e.quantity, a.list[r.value].color = e.color, a.list[r.value].brand = e.brand, a.list[r.value].unitNet = e.unitNet, a.list[r.value].mete = e.quantity * e.unitNet, a.list[r.value].requisitionMode = U.USE_INVENTORY.V, a.list[r.value].materialInventoryId = i;
  }
  function K() {
    return ye(a.branchCompanyId) ? (_.warning("请选择申购单位"), false) : p(h.value) ? (_.error("请先删除标红数据并重新添加"), false) : f.value ? f.value.validate() : true;
  }
  function W() {
    return f.value ? f.value.TSValidate() : true;
  }
  function G(t) {
    return f.value.rowInit(t);
  }
  function x() {
    m.value && m.value.clear();
  }
  function P() {
    var t;
    if (p(h.value) && p((t = l == null ? void 0 : l.submitResult) == null ? void 0 : t.data)) {
      _.error("请删除全部标红数据");
      return;
    }
    y.value = true;
  }
  function X(t) {
    var e;
    try {
      (e = l == null ? void 0 : l.submitResult) != null && e.data && (l.submitResult.data = null), l.props.import(t);
    } catch (i) {
      _.error({ message: i.message, duration: 5e3 });
    }
  }
  return l.props.import = (t) => {
    a.list.push.apply(a.list, t);
    const e = H(m, () => {
      m.value && (m.value.initSelected(t.map((i) => ({ sn: i.sn, classifyId: i.classifyId }))), ae(() => {
        e();
      }));
    }, { immediate: true });
  }, D({ form: a, TSValidateTable: W }), (t, e) => {
    const i = k("common-button"), s = ne, g = le, Z = k("common-drawer");
    return ie(), se("div", xe, [o(be, { "basic-class": n(I), isTsData: S.isTsData, "show-total": false, validate: K }, { default: d(() => {
      var c, B;
      return [w("div", ge, [w("div", we, [w("div", Se, [o(ce, { "right-label": J.value, "show-unit": "" }, null, 8, ["right-label"])]), o(i, { class: "filter-item", type: "success", onClick: P }, { default: d(() => e[3] || (e[3] = [C(" 添加物料 ")])), _: 1, __: [3] }), o(s, { content: "请删除全部标红数据", disabled: !(n(p)(h.value) && n(p)((B = (c = n(l)) == null ? void 0 : c.submitResult) == null ? void 0 : B.data)), class: "item", effect: "dark", placement: "top" }, { default: d(() => [o(me, { template: n(_e), "btn-name": "清单导入", "btn-size": "default", "btn-type": "warning", class: "filter-item", icon: "el-icon-upload2", "open-loading": "", onSuccess: X }, null, 8, ["template"])]), _: 1 }, 8, ["disabled"]), o(fe, { fn: n(de), params: { basicClass: n(I), receiptType: n(pe).REQUISITIONS.V }, class: "filter-item", size: "default", type: "info" }, { default: d(() => e[4] || (e[4] = [C(" 办公用品清单模板下载 ")])), _: 1, __: [4] }, 8, ["fn", "params"])])]), o(g, { ref_key: "formRef", ref: T, model: n(a) }, { default: d(() => [o(Ie, { ref_key: "tableRef", ref: f, "max-height": n(Y), onSearchInventory: $ }, null, 8, ["max-height"])]), _: 1 }, 8, ["model"])];
    }), _: 1 }, 8, ["basic-class", "isTsData"]), o(Z, { ref_key: "drawerRef", ref: R, modelValue: y.value, "onUpdate:modelValue": e[1] || (e[1] = (c) => y.value = c), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: d(() => [o(ve, { ref_key: "matSpecRef", ref: m, modelValue: n(a).list, "onUpdate:modelValue": e[0] || (e[0] = (c) => n(a).list = c), "basic-class": n(I), "max-height": n(L), "row-init-fn": G, "table-width": 430, visible: y.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "max-height", "visible"])]), _: 1 }, 8, ["modelValue"]), o(n(he), { visible: b.value, "onUpdate:visible": e[2] || (e[2] = (c) => b.value = c), params: V.value, onUseInventory: A }, null, 8, ["visible", "params"])]);
  };
} }, Ce = oe(Te, [["__scopeId", "data-v-8da48ca6"]]);
export {
  Ce as default
};
