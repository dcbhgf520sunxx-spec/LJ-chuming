import { ref as u } from "vue";
import { provide as C } from "vue";
import { watch as M } from "vue";
import { computed as B } from "vue";
import { watchEffect as te } from "vue";
import { nextTick as ae } from "vue";
import { resolveComponent as q } from "vue";
import { openBlock as ie } from "vue";
import { createElementBlock as se } from "vue";
import { createVNode as o } from "vue";
import { withCtx as f } from "vue";
import { createElementVNode as g } from "vue";
import { createTextVNode as N } from "vue";
import { unref as l } from "vue";
import { ElMessage as y } from "element-plus";
import { ElTooltip as le } from "element-plus";
import { ElForm as ne } from "element-plus";
import { _ as oe, cP as b, am as re, tB as ue, w1 as H, o as O, i as p, wc as k, wo as ce, vv as me, L as de, wn as fe, vx as pe, cQ as ve, b as _e } from "../../../../../../shared/runtime.js";
import { s as ye } from "../../../../../../modules/aux-material-a427f83d.js";
import be from "../components/common-wrapper.vue.js";
import Ie from "./module/aux-mat-table.vue.js";
import he from "../components/inventory-drawer.vue.js";
import "../components/common-footer.vue.js";
import "../components/confirm-dialog.vue.js";
const Se = { class: "aux-mat-requisitions-application-container" }, xe = { class: "filter-container" }, Ee = { class: "filter-right-box" }, ge = { class: "filter-item" }, Te = { __name: "index", props: { detail: { type: Object }, isEdit: { type: Boolean, default: false }, isTsData: { type: Boolean, default: false } }, emits: ["success"], setup(A, { expose: U, emit: F }) {
  const z = F, v = A, D = { list: [], projectAttribute: void 0, branchCompanyId: void 0, originInventoryInfo: {}, steelPlateList: [], sectionSteelList: [], steelCoilList: [], otherSteelMaterials: [], MATERIAL: [], OTHER: [], GAS: [], all: [] };
  b.STEEL_PLATE.V, b.SECTION_STEEL.V, b.STEEL_COIL.V, b.OTHER_STEEL_MATERIALS.V;
  const d = u(), m = u(), T = u(), w = u(), I = u(false), V = u({}), r = u(), _ = u(false), h = re.MATERIAL.V, R = u({});
  C("useInventoryInfo", R), C("matSpecRef", m);
  const { cu: n, form: a, FORM: K } = ue({ title: "辅材申购", defaultForm: D, clearDraftCallback: x, api: v.isEdit ? H.edit : H.add }, T, v.detail);
  M(() => v.detail, (t = {}) => {
    a.materialType = t.materialType, a.branchCompanyId = t.branchCompanyId, a.level = t.level;
  }, { deep: true, immediate: true });
  const { maxHeight: P } = O({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => w.value.loaded), { maxHeight: Q } = O({ mainBox: ".requisitions-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".requisitions-application-header", ".requisitions-application-select", ".requisitions-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: v.isTsData ? 0 : 200 }), j = B(() => {
    var i;
    let t = [], e = [];
    return p(a.list) && (t = JSON.parse(JSON.stringify(a.list)), e = (i = Array.from(new Set(t == null ? void 0 : t.map((s) => s.classifyId)))) == null ? void 0 : i.map((s) => t == null ? void 0 : t.find((E) => E.classifyId === s))), e.length;
  }), S = B(() => {
    var t;
    return (t = a.list) == null ? void 0 : t.filter((e) => {
      var i, s;
      return (s = (i = n == null ? void 0 : n.submitResult) == null ? void 0 : i.data) == null ? void 0 : s.includes(e.classifyId);
    });
  });
  x(), te(() => {
    var t;
    if ((t = a.list) != null && t.length) {
      const e = {};
      for (let i = 0; i < a.list.length; i++) {
        const s = a.list[i];
        s.requisitionMode === k.USE_INVENTORY.V && (e[s.materialInventoryId] ? e[s.materialInventoryId] += s.quantity : e[s.materialInventoryId] = s.quantity);
      }
      R.value = e;
    }
  }), K.HOOK.afterSubmit = () => {
    z("success"), x();
  };
  function J(t, e) {
    V.value = t, r.value = e, I.value = true;
  }
  function Y(t, e) {
    const i = e.id;
    a.originInventoryInfo || (a.originInventoryInfo = {}), a.originInventoryInfo[i] = { quantity: e.quantity, frozenQuantity: e.frozenQuantity }, a.list[r.value].quantity = t, a.list[r.value].canUseQuantity = e.quantity, a.list[r.value].color = e.color, a.list[r.value].brand = e.brand, a.list[r.value].unitNet = e.unitNet, a.list[r.value].mete = e.quantity * e.unitNet, a.list[r.value].requisitionMode = k.USE_INVENTORY.V, a.list[r.value].materialInventoryId = i;
  }
  function $() {
    return _e(a.branchCompanyId) ? (y.warning("请选择申购单位"), false) : p(S.value) ? (y.error("请先删除标红数据并重新添加"), false) : d.value ? d.value.validate() : true;
  }
  function G() {
    return d.value ? d.value.TSValidate() : true;
  }
  function W(t) {
    return d.value.rowInit(t);
  }
  function x() {
    m.value && m.value.clear();
  }
  function X() {
    var t;
    if (p(S.value) && p((t = n == null ? void 0 : n.submitResult) == null ? void 0 : t.data)) {
      y.error("请删除全部标红数据");
      return;
    }
    _.value = true;
  }
  function Z(t) {
    var e;
    try {
      (e = n == null ? void 0 : n.submitResult) != null && e.data && (n.submitResult.data = null), n.props.import(t);
    } catch (i) {
      y.error({ message: i.message, duration: 5e3 });
    }
  }
  return n.props.import = (t) => {
    a.list.push.apply(a.list, t);
    const e = M(m, () => {
      m.value && (m.value.initSelected(t.map((i) => ({ sn: i.sn, classifyId: i.classifyId }))), ae(() => {
        e();
      }));
    }, { immediate: true });
  }, U({ form: a, TSValidateTable: G }), (t, e) => {
    const i = q("common-button"), s = le, E = ne, ee = q("common-drawer");
    return ie(), se("div", Se, [o(be, { "basic-class": l(h), "is-ts-data": v.isTsData, "show-total": false, validate: $ }, { default: f(() => {
      var c, L;
      return [g("div", xe, [g("div", Ee, [g("div", ge, [o(ce, { "right-label": j.value, "show-unit": "" }, null, 8, ["right-label"])]), o(i, { class: "filter-item", type: "success", onClick: X }, { default: f(() => e[3] || (e[3] = [N(" 添加物料 ")])), _: 1, __: [3] }), o(s, { content: "请删除全部标红数据", disabled: !(l(p)(S.value) && l(p)((L = (c = l(n)) == null ? void 0 : c.submitResult) == null ? void 0 : L.data)), class: "item", effect: "dark", placement: "top" }, { default: f(() => [o(me, { template: l(ye), "btn-name": "清单导入", "btn-size": "default", "btn-type": "warning", class: "filter-item", icon: "el-icon-upload2", "open-loading": "", onSuccess: Z }, null, 8, ["template"])]), _: 1 }, 8, ["disabled"]), o(de, { fn: l(fe), params: { basicClass: l(h), receiptType: l(pe).REQUISITIONS.V }, class: "filter-item", size: "default", type: "info" }, { default: f(() => e[4] || (e[4] = [N(" 辅材清单模板下载 ")])), _: 1, __: [4] }, 8, ["fn", "params"])])]), o(E, { ref_key: "formRef", ref: T, model: l(a) }, { default: f(() => [o(Ie, { ref_key: "tableRef", ref: d, "max-height": l(Q), onSearchInventory: J }, null, 8, ["max-height"])]), _: 1 }, 8, ["model"])];
    }), _: 1 }, 8, ["basic-class", "is-ts-data"]), o(ee, { ref_key: "drawerRef", ref: w, modelValue: _.value, "onUpdate:modelValue": e[1] || (e[1] = (c) => _.value = c), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: f(() => [o(ve, { ref_key: "matSpecRef", ref: m, modelValue: l(a).list, "onUpdate:modelValue": e[0] || (e[0] = (c) => l(a).list = c), "basic-class": l(h), "max-height": l(P) - 100, "row-init-fn": W, "table-width": 430, visible: _.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "max-height", "visible"])]), _: 1 }, 8, ["modelValue"]), o(l(he), { visible: I.value, "onUpdate:visible": e[2] || (e[2] = (c) => I.value = c), params: V.value, onUseInventory: Y }, null, 8, ["visible", "params"])]);
  };
} }, Ne = oe(Te, [["__scopeId", "data-v-3d72a131"]]);
export {
  Ne as default
};
