import { useStore as ne } from "vuex";
import { ref as c } from "vue";
import { computed as y } from "vue";
import { provide as re } from "vue";
import { watch as R } from "vue";
import { nextTick as g } from "vue";
import { resolveComponent as j } from "vue";
import { resolveDirective as ce } from "vue";
import { withDirectives as de } from "vue";
import { unref as m } from "vue";
import { openBlock as E } from "vue";
import { createElementBlock as pe } from "vue";
import { createVNode as M } from "vue";
import { withCtx as w } from "vue";
import { createElementVNode as L } from "vue";
import { createBlock as W } from "vue";
import { createTextVNode as me } from "vue";
import { createCommentVNode as q } from "vue";
import { reactive as fe } from "vue";
import { ElMessage as U } from "element-plus";
import { ElTooltip as ve } from "element-plus";
import { ElForm as he } from "element-plus";
import { _ as be, am as xe, jY as _e, gS as ye, i as x, bs as ge, D as Me, tB as we, yr as K, yk as Se, ys as Ae, o as Y, b as $, cQ as Be, aI as z, jZ as Re } from "../../../../../../shared/runtime.js";
import Pe from "../components/common-wrapper.vue.js";
import ke from "./module/aux-mat-table.vue.js";
import "../components/common-header.vue.js";
import "../components/common-footer.vue.js";
import "../components/confirm-dialog.vue.js";
import "../../../../../../modules/index-e817c507.js";
import "../../components/project-set-columns.vue.js";
import "../../components/warehouse-set-columns.vue.js";
import "../../../../../../modules/use-over-receive-ba08adae.js";
const He = { class: "aux-mat-inbound-application-container" }, Ce = { class: "filter-container" }, Ee = { class: "filter-right-box" }, Le = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success"], setup(Q, { emit: X }) {
  const T = ne(), Z = X, f = Q, G = { purchaseId: null, loadingWeight: null, licensePlate: null, shipmentNumber: null, logistics: {}, list: [], auxMatList: [] }, v = c(), u = c(), I = c(), V = c(), d = c(), D = c(false), o = c(false), b = c(false), S = c(false), A = xe.MATERIAL.V, { inboundFillWayCfg: O } = _e(), P = y(() => O.value ? O.value.amountFillWay === ye.APPLICATION.V : false), J = y(() => {
    var e, a;
    return !!((a = (e = d.value) == null ? void 0 : e.applyPurchase) != null && a.length);
  }), k = y(() => !!(A && d.value)), ee = y(() => {
    let e = 0;
    return o.value || x(s.auxMatList) && s.auxMatList.forEach((a) => {
      x(a.amount) && (e += +a.amount);
    }), ge(e, Me.YUAN);
  });
  re("matSpecRef", u);
  const H = (e) => {
    var t;
    e.auxMatList = (t = e.auxMatList) == null ? void 0 : t.map((i) => fe(i));
    const a = R(v, (i) => {
      if (i) {
        g(() => {
          var l;
          (l = v.value) == null || l.setSelect();
        }), o.value || e.auxMatList.forEach((l) => {
          var h, r;
          v.value.rowWatch(l), !o.value && !b.value && ((r = (h = e.selectObj) == null ? void 0 : h[l.mergeId]) != null && r.isSelected) && v.value.toggleRowSelection(l, true);
        });
        const p = R(u, () => {
          u.value && (u.value.initSelected(e.auxMatList.map((l) => ({ sn: l.sn, classifyId: l.classifyId }))), g(() => {
            _.value && (_.value = false), p();
          }));
        }, { immediate: true });
        g(() => {
          a();
        });
      }
    }, { immediate: true, deep: true });
    te();
  }, _ = c(!f.edit), { cu: n, form: s, FORM: N } = we({ title: "辅材入库", formStore: !f.edit, formStoreKey: "WMS_INBOUND_APPLICATION_AUX_MAT", permission: K, defaultForm: G, clearDraftCallback: B, api: f.edit ? Se : Ae }, I, f.detail), { maxHeight: ae } = Y({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => V.value.loaded);
  let C = {};
  f.edit ? C = { mainBox: ".raw-mat-inbound-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".inbound-application-header", ".inbound-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 20 } : C = { mainBox: ".aux-mat-inbound-application-container", extraBox: [".filter-container", ".inbound-application-header", ".inbound-application-footer"], navbar: true, minHeight: 300, extraHeight: 20 };
  const { fixMaxHeight: te, maxHeight: le } = Y(C), F = y(() => {
    var e;
    return (e = s.list) == null ? void 0 : e.filter((a) => {
      var t, i;
      return (i = (t = n == null ? void 0 : n.submitResult) == null ? void 0 : t.data) == null ? void 0 : i.includes(a.classifyId);
    });
  });
  B(), N.HOOK.beforeToEdit = async (e, a) => {
    var t;
    f.edit && (a.purchaseId = (t = a.purchaseOrder) == null ? void 0 : t.id, a.logistics || (a.logistics = {}), (o.value || b.value) && (a.auxMatList = a.list, H(a)));
  }, N.HOOK.afterSubmit = () => {
    f.edit && Z("success"), B();
  };
  function ie() {
    const e = v.value ? v.value.validate() : true;
    if (e) {
      const a = [];
      if (s.auxMatList.forEach((t) => {
        var i, p;
        (i = t.applyPurchase) != null && i.length ? t.applyPurchase.forEach((l) => {
          var h, r;
          (l.quantity || l.mete) && a.push({ ...t, quantity: l.quantity, projectId: (h = l.project) == null ? void 0 : h.id, uid: z(), mete: l.mete, applyPurchaseId: l.applyPurchaseId, purchaseDetailId: l.purchaseDetailId, purchaseProjectDisabled: l.applyPurchaseId ? !((r = l.project) != null && r.id) : false });
        }) : (o.value || b.value || (p = s.selectObj[t.mergeId]) != null && p.isSelected) && a.push(t);
      }), s.list = a, x(F.value)) return U.error("请先删除标红数据并重新添加"), false;
    }
    return e;
  }
  function se(e) {
    return v.value.rowInit(e);
  }
  async function oe(e) {
    var a;
    if (B(), d.value = e, n.props.order = e, o.value = (e == null ? void 0 : e.supplyType) === Re.PARTY_A.V, b.value = $(e == null ? void 0 : e.details), !b.value && !o.value && !_.value && (s.auxMatList = []), _.value) {
      const t = R(u, () => {
        u.value && (u.value.clearByBasicClass(A), g(() => {
          t();
        }));
      }, { immediate: true });
    }
    o.value && _.value && H(s), (a = e == null ? void 0 : e.details) != null && a.length && (s.auxMatList = e.details.map((t) => (t.uid = z(), t)), H(s)), D.value = true;
  }
  function B() {
    D.value = false, o.value = false, s.clickTime = (/* @__PURE__ */ new Date()).getTime();
  }
  function ue() {
    var e, a;
    if (x(F.value) && x((e = n == null ? void 0 : n.submitResult) == null ? void 0 : e.data)) {
      U.error("请删除全部标红数据");
      return;
    }
    S.value = true, ((a = n == null ? void 0 : n.submitResult) == null ? void 0 : a.code) === 40206 && u.value && (T.dispatch("config/fetchMatClsTree"), n.submitResult.code = null, T.state.config.classifySpec = { specKV: [] });
  }
  return n.props.import = (e) => {
    P.value || e.forEach((i) => {
      i.amount = void 0, i.unitPrice = void 0;
    });
    let a = [];
    if (d.value && x(d.value.auxMaterialIds) && !d.value.auxMaterialIds.includes(0) && e.forEach((i) => {
      let p = false;
      for (const l of d.value.auxMaterialIds) if (i.classifyFullPathId.includes(l)) {
        p = true;
        break;
      }
      p || a.push(i.classifyName);
    }), a.length > 0) throw a = Array.from(new Set(a)), new Error(`当前订单辅材明细中不存在${a.map((i) => `“${i}”`).join("、")}等科目`);
    s.auxMatList.push.apply(s.auxMatList, e);
    const t = R(u, () => {
      u.value && (u.value.initSelected(e.map((i) => ({ sn: i.sn, classifyId: i.classifyId }))), g(() => {
        t();
      }));
    }, { immediate: true });
  }, (e, a) => {
    const t = j("common-button"), i = ve, p = he, l = j("common-drawer"), h = ce("permission");
    return de((E(), pe("div", He, [M(Pe, { "basic-class": m(A), edit: f.edit, "show-total": false, "show-total-amount": !o.value && P.value, "total-amount": ee.value, validate: ie, onPurchaseOrderChange: oe }, { default: w(() => [L("div", Ce, [L("div", Ee, [M(i, { disabled: k.value, content: "请先选择采购合同编号", effect: "light", placement: "left-start" }, { default: w(() => {
      var r;
      return [L("span", null, [o.value || !o.value && m($)((r = d.value) == null ? void 0 : r.details) ? (E(), W(t, { key: 0, disabled: !k.value, class: "filter-item", type: "success", onClick: ue }, { default: w(() => a[2] || (a[2] = [me(" 添加物料 ")])), _: 1, __: [2] }, 8, ["disabled"])) : q("", true)])];
    }), _: 1 }, 8, ["disabled"])])]), M(p, { ref_key: "formRef", ref: I, model: m(s) }, { default: w(() => [M(ke, { ref_key: "tableRef", ref: v, "bool-apply-purchase": J.value, "bool-party-a": o.value, fillableAmount: P.value, "max-height": m(le), noDetail: b.value }, null, 8, ["bool-apply-purchase", "bool-party-a", "fillableAmount", "max-height", "noDetail"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["basic-class", "edit", "show-total-amount", "total-amount"]), M(l, { ref_key: "drawerRef", ref: V, modelValue: S.value, "onUpdate:modelValue": a[1] || (a[1] = (r) => S.value = r), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: w(() => [k.value ? (E(), W(Be, { key: 0, ref_key: "matSpecRef", ref: u, modelValue: m(s).auxMatList, "onUpdate:modelValue": a[0] || (a[0] = (r) => m(s).auxMatList = r), "basic-class": m(A), "classify-ids": d.value.auxMaterialIds, "max-height": m(ae), "row-init-fn": se, "table-width": 430, visible: S.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "classify-ids", "max-height", "visible"])) : q("", true)]), _: 1 }, 8, ["modelValue"])])), [[h, m(K)]]);
  };
} }, Ke = be(Le, [["__scopeId", "data-v-82c67e9a"]]);
export {
  Ke as default
};
