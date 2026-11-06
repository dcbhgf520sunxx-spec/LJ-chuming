import { ref as S } from "vue";
import { provide as Y } from "vue";
import { reactive as G } from "vue";
import { computed as C } from "vue";
import { watchEffect as Ie } from "vue";
import { watch as w } from "vue";
import { nextTick as x } from "vue";
import { resolveComponent as X } from "vue";
import { openBlock as N } from "vue";
import { createElementBlock as Z } from "vue";
import { createVNode as g } from "vue";
import { withCtx as T } from "vue";
import { createElementVNode as P } from "vue";
import { unref as m } from "vue";
import { ElRadioGroup as we } from "element-plus";
import { Fragment as Ce } from "vue";
import { renderList as xe } from "vue";
import { createTextVNode as A } from "vue";
import { toDisplayString as F } from "vue";
import { createBlock as ee } from "vue";
import { createCommentVNode as Ve } from "vue";
import { resolveDynamicComponent as Me } from "vue";
import { normalizeStyle as Oe } from "vue";
import { ElMessage as V } from "element-plus";
import { ElRadioButton as Re } from "element-plus";
import { ElTooltip as Ne } from "element-plus";
import { ElForm as Pe } from "element-plus";
import { _ as Be, sQ as Ue, am as b, cP as qe, tB as He, w1 as te, wc as le, c as ae, wj as ie, wk as De, wl as We, wm as Ae, o as se, i as h, bs as Fe, vz as Ke, vv as Qe, L as ze, wn as Je, vw as $e, vx as je, cV as ke, cQ as Ye, b as M } from "../../../../../../shared/runtime.js";
import Ge from "../components/common-wrapper.vue.js";
import Xe from "./module/steel-plate-table.vue.js";
import Ze from "./module/section-steel-table.vue.js";
import et from "./module/steel-coil-table.vue.js";
import tt from "./module/other-steel-materials-table.vue.js";
import lt from "../components/inventory-drawer.vue.js";
import at from "../components/capsule-label/index.vue.js";
import "../components/common-footer.vue.js";
import "../components/confirm-dialog.vue.js";
const it = { class: "steel-requisitions-application-container" }, st = { class: "filter-container" }, nt = { class: "filter-left-box" }, ot = { class: "filter-right-box" }, rt = { class: "filter-item" }, ut = { __name: "index", props: { detail: { type: Object }, isEdit: { type: Boolean, default: false }, isTsData: { type: Boolean, default: false } }, emits: ["success"], setup(K, { expose: ne, emit: oe }) {
  const re = oe, O = K, { baseUnit: I } = Ue(), s = { steelPlateList: { K: "steelPlateList", L: "钢板", V: b.STEEL_PLATE.V, TABLE: Xe }, sectionSteelList: { K: "sectionSteelList", L: "型材", V: b.SECTION_STEEL.V, TABLE: Ze }, steelCoilList: { K: "steelCoilList", L: "钢卷", V: b.STEEL_COIL.V, TABLE: et }, otherSteelMaterialList: { K: "otherSteelMaterialList", L: "其他钢材", V: qe.OTHER_STEEL_MATERIALS.V, TABLE: tt } }, ue = { list: [], steelPlateList: [], sectionSteelList: [], steelCoilList: [], otherSteelMaterialList: [], originInventoryInfo: {} }, B = S(), _ = S(), Q = S(), z = S(), R = S(false), U = S(false), J = S({}), u = S(), a = S(), E = S([]), $ = S({});
  Y("useInventoryInfo", $);
  const v = G({ steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null });
  Y("matSpecRef", _);
  const j = (e) => {
    const t = { steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null }, n = { steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null }, o = ["steelPlateList", "sectionSteelList", "steelCoilList", "otherSteelMaterialList"];
    let f = false;
    o.forEach((i) => {
      h(e[i]) && (f || (f = true, a.value = i), e[i] = e[i].map((d) => G(d)), t[i] = w(v, (d) => {
        d[i] && (e[i].forEach((p) => d[i].rowWatch(p)), n[i] = w(_, () => {
          _.value && (_.value.initSelected(e[i].map((p) => ({ sn: p.sn, classifyId: p.classifyId }))), x(() => {
            n[i]();
          }));
        }, { immediate: true }), x(() => {
          t[i]();
        }));
      }, { immediate: true, deep: true }));
    });
  }, { cu: L, form: l, FORM: k } = He({ title: "钢材申购", defaultForm: ue, useDraftCallback: j, clearDraftCallback: H, api: O.isEdit ? te.edit : te.add }, Q, O.detail), q = C(() => {
    var e;
    return (e = l.list) == null ? void 0 : e.filter((t) => {
      var n, o;
      return (o = (n = L == null ? void 0 : L.submitResult) == null ? void 0 : n.data) == null ? void 0 : o.includes(t.classifyId);
    });
  });
  Ie(() => {
    var e, t, n, o, f, i, d, p;
    if ((e = E.value) != null && e.length) {
      const c = {};
      for (let y = 0; y < E.value.length; y++) {
        const r = E.value[y];
        if (r.requisitionMode === le.USE_INVENTORY.V) {
          const D = (t = l.originInventoryInfo[r.materialInventoryId]) == null ? void 0 : t.basicClass, W = D & b.STEEL_COIL.V && r.basicClass & b.STEEL_COIL.V ? ae(r.length, (o = (n = I.value[r.basicClass]) == null ? void 0 : n.length) == null ? void 0 : o.unit, (i = (f = I.value[D]) == null ? void 0 : f.measure) == null ? void 0 : i.unit, (p = (d = I.value[D]) == null ? void 0 : d.measure) == null ? void 0 : p.precision) : r.quantity;
          r.useQuantity = W, c[r.materialInventoryId] ? c[r.materialInventoryId] += W : c[r.materialInventoryId] = W;
        }
      }
      $.value = c;
    }
  });
  const ce = C(() => {
    switch (a.value) {
      case s.steelPlateList.K:
        return ie;
      case s.sectionSteelList.K:
        return Ae;
      case s.steelCoilList.K:
        return We;
      case s.otherSteelMaterialList.K:
        return De;
      default:
        return ie;
    }
  });
  w(() => O.detail, (e = {}) => {
    l.materialType = e.materialType, l.branchCompanyId = e.branchCompanyId, l.level = e.level;
  }, { deep: true, immediate: true });
  const { maxHeight: me } = se({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => z.value.loaded), { maxHeight: fe, maxHeightStyle: de } = se({ mainBox: ".requisitions-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".requisitions-application-header", ".requisitions-application-select", ".requisitions-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: O.isTsData ? 0 : 200 }), ve = C(() => {
    var d;
    let e = [], t = [], n = [], o = [], f = [], i = [];
    return h(l.steelPlateList) && (n = JSON.parse(JSON.stringify(l.steelPlateList))), h(l.sectionSteelList) && (o = JSON.parse(JSON.stringify(l.sectionSteelList))), h(l.steelCoilList) && (f = JSON.parse(JSON.stringify(l.steelCoilList))), h(l.otherSteelMaterialList) && (i = JSON.parse(JSON.stringify(l.otherSteelMaterialList))), l[a.value] && (e = [...n, ...o, ...f, ...i], t = (d = Array.from(new Set(e == null ? void 0 : e.map((p) => p.classifyId)))) == null ? void 0 : d.map((p) => e == null ? void 0 : e.find((c) => c.classifyId === p))), t.length;
  }), pe = C(() => {
    var e;
    return ((e = s == null ? void 0 : s[a.value]) == null ? void 0 : e.TABLE) || s.steelPlateList.TABLE;
  }), Le = C(() => {
    let e = 0;
    return h(l.steelPlateList) && l.steelPlateList.forEach((t) => {
      e += t.weighingTotalWeight ? t.weighingTotalWeight : 0;
    }), h(l.sectionSteelList) && l.sectionSteelList.forEach((t) => {
      e += t.weighingTotalWeight ? t.weighingTotalWeight : 0;
    }), h(l.steelCoilList) && l.steelCoilList.forEach((t) => {
      e += t.weighingTotalWeight ? t.weighingTotalWeight : 0;
    }), Fe(e, 2);
  });
  w(a, (e) => {
    E.value = l[e], e && x(() => {
      v[e] || (v[e] = B.value);
    });
  }, { immediate: true }), w(E, (e) => {
    l[a.value] = e;
  }, { deep: true });
  function he(e, t) {
    J.value = e, u.value = t, U.value = true;
  }
  function Se(e, t) {
    var f, i, d;
    const n = t.id;
    l.originInventoryInfo || (l.originInventoryInfo = {}), l.originInventoryInfo[n] = { quantity: t.quantity, frozenQuantity: t.frozenQuantity, basicClass: t.basicClass };
    const o = (f = s == null ? void 0 : s[a.value]) == null ? void 0 : f.V;
    o & b.STEEL_PLATE.V && (t.basicClass & b.STEEL_COIL.V ? (l[a.value][u.value].length = ae(e, (d = (i = I.value[t.basicClass]) == null ? void 0 : i.measure) == null ? void 0 : d.unit, I.value[o].length.unit, I.value[o].length.precision), l[a.value][u.value].quantity = 1, l[a.value][u.value].canUseQuantity = 1) : (l[a.value][u.value].length = t.length, l[a.value][u.value].quantity = e, l[a.value][u.value].canUseQuantity = t.quantity), l[a.value][u.value].width = t.width), o & b.SECTION_STEEL.V && (l[a.value][u.value].quantity = e, l[a.value][u.value].length = t.length, l[a.value][u.value].canUseQuantity = t.quantity), o & b.STEEL_COIL.V && (l[a.value][u.value].quantity = e, l[a.value][u.value].canUseQuantity = t.quantity), l[a.value][u.value].color = t.color, l[a.value][u.value].brand = t.brand, l[a.value][u.value].requisitionMode = le.USE_INVENTORY.V, l[a.value][u.value].materialInventoryId = n;
  }
  H(), k.HOOK.beforeToEdit = async (e, t) => {
    await Ke(t), j(t);
  }, k.HOOK.afterSubmit = () => {
    re("success"), H();
  };
  function ge() {
    if (M(l.branchCompanyId)) return V.warning("请选择申购单位"), false;
    if (M(l.steelPlateList) && M(l.sectionSteelList) && M(l.steelCoilList) && M(l.otherSteelMaterialList)) return V.warning("请填写数据"), false;
    const e = _e();
    return e && (l.list = [...l.steelPlateList, ...l.sectionSteelList, ...l.steelCoilList], l.list.forEach((t) => {
      t.mete = t.weighingTotalWeight, t.weight = t.weighingTotalWeight;
    }), l.list = [...l.list, ...l.otherSteelMaterialList], h(q.value)) ? (V.error("请先删除标红数据并重新添加"), false) : e;
  }
  function _e() {
    return Object.keys(v).every((e) => v[e] ? v[e].validate() : true);
  }
  function be() {
    return Object.keys(v).every((e) => v[e] ? v[e].TSValidate() : true);
  }
  function ye(e) {
    return B.value.rowInit(e);
  }
  function H() {
    x(() => {
      v.steelPlateList = null, v.sectionSteelList = null, v.steelCoilList = null, v.otherSteelMaterialList = null, a.value = s.steelPlateList.K, _.value && _.value.clear();
    });
  }
  function Te() {
    var e;
    if (h(q.value) && h((e = L == null ? void 0 : L.submitResult) == null ? void 0 : e.data)) {
      V.error("请删除全部标红数据");
      return;
    }
    R.value = true;
  }
  function Ee(e) {
    var t;
    try {
      (t = L == null ? void 0 : L.submitResult) != null && t.data && (L.submitResult.data = null), L.props.import(e);
    } catch (n) {
      V.error({ message: n.message, duration: 5e3 });
    }
  }
  return L.props.import = (e) => {
    const t = a.value, n = l[t].length;
    l[t].push.apply(l[t], e);
    const o = l[t].length;
    if (t !== s.otherSteelMaterialList.K) for (let i = n; i < o; i++) v[t].rowWatch(l[t][i]);
    const f = w(_, () => {
      _.value && (_.value.initSelected(e.map((i) => ({ sn: i.sn, classifyId: i.classifyId }))), x(() => {
        f();
      }));
    }, { immediate: true });
  }, ne({ form: l, TSValidateTable: be }), (e, t) => {
    var p;
    const n = Re, o = X("common-button"), f = Ne, i = Pe, d = X("common-drawer");
    return N(), Z("div", it, [g(Ge, { "basic-class": m(ke), "current-basic-class": (p = s == null ? void 0 : s[a.value]) == null ? void 0 : p.V, isTsData: K.isTsData, "show-total-amount": true, "total-value": Le.value, validate: ge, "total-name": "总量合计", unit: "kg" }, { default: T(() => {
      var c, y;
      return [P("div", st, [P("div", nt, [g(m(we), { modelValue: a.value, "onUpdate:modelValue": t[0] || (t[0] = (r) => a.value = r), class: "filter-item", size: "default" }, { default: T(() => [(N(), Z(Ce, null, xe(s, (r) => g(n, { key: r.K, label: r.K }, { default: T(() => [A(F(r.L) + F(m(l)[r.K] && m(l)[r.K].length ? `(${m(l)[r.K].length})` : ""), 1)]), _: 2 }, 1032, ["label"])), 64))]), _: 1 }, 8, ["modelValue"])]), P("div", ot, [P("div", rt, [g(at, { "right-label": ve.value, "show-unit": "" }, null, 8, ["right-label"])]), g(o, { class: "filter-item", type: "success", onClick: Te }, { default: T(() => t[4] || (t[4] = [A(" 添加物料 ")])), _: 1, __: [4] }), g(f, { content: "请删除全部标红数据", disabled: !(m(h)(q.value) && m(h)((y = (c = m(L)) == null ? void 0 : c.submitResult) == null ? void 0 : y.data)), class: "item", effect: "dark", placement: "top" }, { default: T(() => [g(Qe, { template: ce.value, "btn-name": "清单导入", "btn-size": "default", "btn-type": "warning", class: "filter-item", icon: "el-icon-upload2", "open-loading": "", onSuccess: Ee }, null, 8, ["template"])]), _: 1 }, 8, ["disabled"]), a.value ? (N(), ee(ze, { key: 0, fn: a.value !== s.otherSteelMaterialList.K ? m(Je) : m($e), params: { basicClass: s[a.value].V, receiptType: m(je).REQUISITIONS.V }, class: "filter-item", size: "default", type: "info" }, { default: T(() => [A(F(s[a.value].L) + "清单模板下载 ", 1)]), _: 1 }, 8, ["fn", "params"])) : Ve("", true)])]), g(i, { ref_key: "formRef", ref: Q, model: m(l) }, { default: T(() => [(N(), ee(Me(pe.value), { ref_key: "steelRef", ref: B, "max-height": m(fe), style: Oe(m(de)), onSearchInventory: he }, null, 40, ["max-height", "style"]))]), _: 1 }, 8, ["model"])];
    }), _: 1 }, 8, ["basic-class", "current-basic-class", "isTsData", "total-value"]), g(d, { ref_key: "drawerRef", ref: z, modelValue: R.value, "onUpdate:modelValue": t[2] || (t[2] = (c) => R.value = c), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: T(() => {
      var c;
      return [g(Ye, { ref_key: "matSpecRef", ref: _, modelValue: E.value, "onUpdate:modelValue": t[1] || (t[1] = (y) => E.value = y), "basic-class": (c = s == null ? void 0 : s[a.value]) == null ? void 0 : c.V, "max-height": m(me), "row-init-fn": ye, "table-width": 350, visible: R.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "max-height", "visible"])];
    }), _: 1 }, 8, ["modelValue"]), g(m(lt), { visible: U.value, "onUpdate:visible": t[3] || (t[3] = (c) => U.value = c), params: J.value, onUseInventory: Se }, null, 8, ["visible", "params"])]);
  };
} }, bt = Be(ut, [["__scopeId", "data-v-f13bb681"]]);
export {
  bt as default
};
