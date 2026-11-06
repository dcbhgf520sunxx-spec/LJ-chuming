import { useStore as te } from "vuex";
import { ref as o } from "vue";
import { computed as h } from "vue";
import { provide as ae } from "vue";
import { watch as B } from "vue";
import { nextTick as H } from "vue";
import { resolveComponent as N } from "vue";
import { resolveDirective as ie } from "vue";
import { withDirectives as le } from "vue";
import { unref as n } from "vue";
import { openBlock as P } from "vue";
import { createElementBlock as se } from "vue";
import { createVNode as u } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as R } from "vue";
import { createTextVNode as oe } from "vue";
import { createBlock as ne } from "vue";
import { createCommentVNode as re } from "vue";
import { reactive as ce } from "vue";
import { ElMessage as E } from "element-plus";
import { ElTooltip as ue } from "element-plus";
import { ElForm as de } from "element-plus";
import { _ as me, am as pe, jY as fe, gS as be, i as f, bs as _e, D as ve, tB as he, yu as D, yk as ge, yv as xe, o as W, cQ as ye, jZ as we } from "../../../../../../shared/runtime.js";
import Se from "../components/common-wrapper.vue.js";
import Be from "./module/gas-table.vue.js";
import "../components/common-header.vue.js";
import "../components/common-footer.vue.js";
import "../components/confirm-dialog.vue.js";
import "../../../../../../modules/index-e817c507.js";
import "../../components/project-set-columns.vue.js";
import "../../components/warehouse-set-columns.vue.js";
const He = { class: "gas-inbound-application-container" }, Re = { class: "filter-container" }, Ae = { class: "filter-right-box" }, Ce = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success"], setup(j, { emit: K }) {
  const A = te(), U = K, r = j, G = { purchaseId: null, loadingWeight: null, licensePlate: null, shipmentNumber: null, logistics: {}, list: [] }, d = o(), i = o(), C = o(), k = o(), T = o(), V = o(false), m = o(false), b = o(false), g = pe.GAS.V, { inboundFillWayCfg: I } = fe(), x = h(() => I.value ? I.value.amountFillWay === be.APPLICATION.V : false), y = h(() => !!(g && T.value)), Y = h(() => {
    let e = 0;
    return m.value || f(l.list) && l.list.forEach((t) => {
      f(t.amount) && (e += +t.amount);
    }), _e(e, ve.YUAN);
  });
  ae("matSpecRef", i);
  const M = (e) => {
    e.list = e.list.map((a) => ce(a));
    const t = B(d, (a) => {
      if (a) {
        const c = B(i, () => {
          i.value && (i.value.initSelected(e.list.map((v) => ({ sn: v.sn, classifyId: v.classifyId }))), H(() => {
            c();
          }));
        }, { immediate: true });
        H(() => {
          t();
        });
      }
    }, { immediate: true, deep: true });
    L();
  }, { cu: s, form: l, FORM: O } = he({ title: "气体入库", formStore: !r.edit, formStoreKey: "WMS_INBOUND_APPLICATION_GAS", permission: D, defaultForm: G, useDraftCallback: M, clearDraftCallback: _, api: r.edit ? ge : xe }, C, r.detail), { maxHeight: q } = W({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => k.value.loaded);
  let w = {};
  r.edit ? w = { mainBox: ".raw-mat-inbound-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".inbound-application-header", ".inbound-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 20 } : w = { mainBox: ".gas-inbound-application-container", extraBox: [".filter-container", ".inbound-application-header", ".inbound-application-footer"], navbar: true, minHeight: 300, extraHeight: 20 };
  const { fixMaxHeight: L, maxHeight: z } = W(w), F = h(() => {
    var e;
    return (e = l.list) == null ? void 0 : e.filter((t) => {
      var a, c;
      return (c = (a = s == null ? void 0 : s.submitResult) == null ? void 0 : a.data) == null ? void 0 : c.includes(t.classifyId);
    });
  });
  _(), O.HOOK.beforeToEdit = async (e, t) => {
    var a;
    r.edit && (t.purchaseId = (a = t.purchaseOrder) == null ? void 0 : a.id, t.logistics || (t.logistics = {}), M(t));
  }, O.HOOK.afterSubmit = () => {
    r.edit && U("success"), _();
  };
  function Q() {
    return f(F.value) ? (E.error("请先删除标红数据并重新添加"), false) : d.value ? d.value.validate() : true;
  }
  function Z(e) {
    return d.value.rowInit(e);
  }
  function $(e) {
    _(), T.value = e, s.props.order = e, m.value = (e == null ? void 0 : e.supplyType) === we.PARTY_A.V, V.value = true;
  }
  function _() {
    V.value = false, m.value = false, l.clickTime = (/* @__PURE__ */ new Date()).getTime();
  }
  function J() {
    var e;
    if (f(F.value) && f(s.submitResult.data)) {
      E.error("请删除全部标红数据");
      return;
    }
    b.value = true, ((e = s.submitResult) == null ? void 0 : e.code) === 40206 && i.value && (A.dispatch("config/fetchMatClsTree"), s.submitResult.code = null, A.state.config.classifySpec = { specKV: [] });
  }
  return s.props.import = (e) => {
    x.value || e.forEach((a) => {
      a.amount = void 0, a.unitPrice = void 0;
    }), l.list.push.apply(l.list, e);
    const t = B(i, () => {
      i.value && (i.value.initSelected(e.map((a) => ({ sn: a.sn, classifyId: a.classifyId }))), H(() => {
        t();
      }));
    }, { immediate: true });
  }, (e, t) => {
    const a = N("common-button"), c = ue, v = de, X = N("common-drawer"), ee = ie("permission");
    return le((P(), se("div", He, [u(Se, { "basic-class": n(g), edit: r.edit, "show-total": false, "show-total-amount": !m.value && x.value, "total-amount": Y.value, validate: Q, onPurchaseOrderChange: $ }, { default: p(() => [R("div", Re, [R("div", Ae, [u(c, { disabled: y.value, content: "请先选择采购合同编号", effect: "light", placement: "left-start" }, { default: p(() => [R("span", null, [u(a, { disabled: !y.value, class: "filter-item", type: "success", onClick: J }, { default: p(() => t[2] || (t[2] = [oe(" 添加物料 ")])), _: 1, __: [2] }, 8, ["disabled"])])]), _: 1 }, 8, ["disabled"])])]), u(v, { ref_key: "formRef", ref: C, model: n(l) }, { default: p(() => [u(Be, { ref_key: "tableRef", ref: d, "bool-party-a": m.value, fillableAmount: x.value, "max-height": n(z) }, null, 8, ["bool-party-a", "fillableAmount", "max-height"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["basic-class", "edit", "show-total-amount", "total-amount"]), u(X, { ref_key: "drawerRef", ref: k, modelValue: b.value, "onUpdate:modelValue": t[1] || (t[1] = (S) => b.value = S), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: p(() => [y.value ? (P(), ne(ye, { key: 0, ref_key: "matSpecRef", ref: i, modelValue: n(l).list, "onUpdate:modelValue": t[0] || (t[0] = (S) => n(l).list = S), "basic-class": n(g), "max-height": n(q), "row-init-fn": Z, "table-width": 350, visible: b.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "max-height", "visible"])) : re("", true)]), _: 1 }, 8, ["modelValue"])])), [[ee, n(D)]]);
  };
} }, De = me(Ce, [["__scopeId", "data-v-a46bf20e"]]);
export {
  De as default
};
