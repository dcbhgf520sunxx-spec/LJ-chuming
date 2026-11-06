import { useStore as ne } from "vuex";
import { ref as u } from "vue";
import { computed as x } from "vue";
import { provide as re } from "vue";
import { watch as R } from "vue";
import { nextTick as y } from "vue";
import { resolveComponent as F } from "vue";
import { resolveDirective as ue } from "vue";
import { withDirectives as ce } from "vue";
import { unref as p } from "vue";
import { openBlock as k } from "vue";
import { createElementBlock as de } from "vue";
import { createVNode as g } from "vue";
import { withCtx as w } from "vue";
import { createElementVNode as E } from "vue";
import { createBlock as j } from "vue";
import { createTextVNode as pe } from "vue";
import { createCommentVNode as W } from "vue";
import { reactive as me } from "vue";
import { ElMessage as q } from "element-plus";
import { ElTooltip as fe } from "element-plus";
import { ElForm as he } from "element-plus";
import { _ as be, am as ve, jY as _e, gS as xe, i as M, bs as ye, D as ge, tB as we, yw as U, yk as Me, yx as Se, o as K, cQ as Be, aI as Y, jZ as Re, b as He } from "../../../../../../shared/runtime.js";
import Pe from "../components/common-wrapper.vue.js";
import Ae from "../auxiliary-material/module/aux-mat-table.vue.js";
import "../components/common-header.vue.js";
import "../components/common-footer.vue.js";
import "../components/confirm-dialog.vue.js";
import "../../../../../../modules/index-e817c507.js";
import "../../components/project-set-columns.vue.js";
import "../../components/warehouse-set-columns.vue.js";
import "../../../../../../modules/use-over-receive-ba08adae.js";
const ke = { class: "aux-mat-inbound-application-container" }, Ee = { class: "filter-container" }, Te = { class: "filter-right-box" }, Ce = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success"], setup($, { emit: z }) {
  const T = ne(), Q = z, m = $, Z = { purchaseId: null, loadingWeight: null, licensePlate: null, shipmentNumber: null, logistics: {}, list: [] }, f = u(), o = u(), C = u(), O = u(), b = u(), V = u(false), r = u(false), v = u(false), S = u(false), _ = ve.OTHER.V, { inboundFillWayCfg: D } = _e(), H = x(() => D.value ? D.value.amountFillWay === xe.APPLICATION.V : false), G = x(() => {
    var e, a;
    return !!((a = (e = b.value) == null ? void 0 : e.applyPurchase) != null && a.length);
  }), P = x(() => !!(_ && b.value)), J = x(() => {
    let e = 0;
    return r.value || M(s.auxMatList) && s.auxMatList.forEach((a) => {
      M(a.amount) && (e += +a.amount);
    }), ye(e, ge.YUAN);
  });
  re("matSpecRef", o);
  const L = (e) => {
    var l;
    e.auxMatList = (l = e.auxMatList) == null ? void 0 : l.map((t) => me(t));
    const a = R(f, (t) => {
      if (t) {
        y(() => {
          var i;
          (i = f.value) == null || i.setSelect();
        }), r.value || e.auxMatList.forEach((i) => {
          var h, d;
          f.value.rowWatch(i), !r.value && !v.value && ((d = (h = e.selectObj) == null ? void 0 : h[i.mergeId]) != null && d.isSelected) && f.value.toggleRowSelection(i, true);
        });
        const c = R(o, () => {
          o.value && (o.value.initSelected(e.auxMatList.map((i) => ({ sn: i.sn, classifyId: i.classifyId }))), y(() => {
            c();
          }));
        }, { immediate: true });
        y(() => {
          a();
        });
      }
    }, { immediate: true, deep: true });
    ae();
  }, X = u(!m.edit), { cu: n, form: s, FORM: I } = we({ title: "其它入库", formStore: !m.edit, formStoreKey: "WMS_INBOUND_APPLICATION_OTHER_MAT", permission: U, defaultForm: Z, clearDraftCallback: B, api: m.edit ? Me : Se }, C, m.detail), { maxHeight: ee } = K({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => O.value.loaded);
  let A = {};
  m.edit ? A = { mainBox: ".raw-mat-inbound-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".inbound-application-header", ".inbound-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 20 } : A = { mainBox: ".aux-mat-inbound-application-container", extraBox: [".filter-container", ".inbound-application-header", ".inbound-application-footer"], navbar: true, minHeight: 300, extraHeight: 20 };
  const { fixMaxHeight: ae, maxHeight: te } = K(A), N = x(() => {
    var e;
    return (e = s.list) == null ? void 0 : e.filter((a) => {
      var l, t;
      return (t = (l = n == null ? void 0 : n.submitResult) == null ? void 0 : l.data) == null ? void 0 : t.includes(a.classifyId);
    });
  });
  B(), I.HOOK.beforeToEdit = async (e, a) => {
    var l;
    m.edit && (a.purchaseId = (l = a.purchaseOrder) == null ? void 0 : l.id, a.logistics || (a.logistics = {}), r.value && (a.auxMatList = a.list, L(a)));
  }, I.HOOK.afterSubmit = () => {
    m.edit && Q("success"), B();
  };
  function ie() {
    const e = f.value ? f.value.validate() : true;
    if (e) {
      const a = [];
      if (s.auxMatList.forEach((l) => {
        var t, c;
        (t = l.applyPurchase) != null && t.length ? l.applyPurchase.forEach((i) => {
          var h, d;
          (i.quantity || i.mete) && a.push({ ...l, quantity: i.quantity, projectId: (h = i.project) == null ? void 0 : h.id, uid: Y(), mete: i.mete, applyPurchaseId: i.applyPurchaseId, purchaseDetailId: i.purchaseDetailId, purchaseProjectDisabled: i.applyPurchaseId ? !((d = i.project) != null && d.id) : false });
        }) : (r.value || v.value || (c = s.selectObj[l.mergeId]) != null && c.isSelected) && a.push(l);
      }), s.list = a, M(N.value)) return q.error("请先删除标红数据并重新添加"), false;
    }
    return e;
  }
  function le(e) {
    return f.value.rowInit(e);
  }
  async function se(e) {
    var l;
    B(), b.value = e, n.props.order = e, r.value = (e == null ? void 0 : e.supplyType) === Re.PARTY_A.V, v.value = He(e == null ? void 0 : e.details), !v.value && !r.value && !X.value && (s.auxMatList = []);
    const a = R(o, () => {
      o.value && (o.value.clearByBasicClass(_), y(() => {
        a();
      }));
    }, { immediate: true });
    (l = e == null ? void 0 : e.details) != null && l.length && (s.auxMatList = e.details.map((t) => (t.uid = Y(), t)), L(s)), V.value = true;
  }
  function B() {
    V.value = false, r.value = false, s.clickTime = (/* @__PURE__ */ new Date()).getTime();
  }
  function oe() {
    var e, a;
    if (M(N.value) && M((e = n == null ? void 0 : n.submitResult) == null ? void 0 : e.data)) {
      q.error("请删除全部标红数据");
      return;
    }
    S.value = true, ((a = n == null ? void 0 : n.submitResult) == null ? void 0 : a.code) === 40206 && o.value && (T.dispatch("config/fetchMatClsTree"), n.submitResult.code = null, T.state.config.classifySpec = { specKV: [] });
  }
  return n.props.import = (e) => {
    H.value || e.forEach((t) => {
      t.amount = void 0, t.unitPrice = void 0;
    });
    let a = [];
    if (b.value.otherMaterialIds.includes(0) || e.forEach((t) => {
      let c = false;
      for (const i of b.value.otherMaterialIds) if (t.classifyFullPathId.includes(i)) {
        c = true;
        break;
      }
      c || a.push(t.classifyName);
    }), a.length > 0) throw a = Array.from(new Set(a)), new Error(`当前订单其它明细中不存在${a.map((t) => `“${t}”`).join("、")}等科目`);
    s.auxMatList.push.apply(s.auxMatList, e);
    const l = R(o, () => {
      o.value && (o.value.initSelected(e.map((t) => ({ sn: t.sn, classifyId: t.classifyId }))), y(() => {
        l();
      }));
    }, { immediate: true });
  }, (e, a) => {
    const l = F("common-button"), t = fe, c = he, i = F("common-drawer"), h = ue("permission");
    return ce((k(), de("div", ke, [g(Pe, { "basic-class": p(_), edit: m.edit, "show-total": false, "show-total-amount": !r.value && H.value, "total-amount": J.value, validate: ie, onPurchaseOrderChange: se }, { default: w(() => [E("div", Ee, [E("div", Te, [g(t, { disabled: P.value, content: "请先选择采购合同编号", effect: "light", placement: "left-start" }, { default: w(() => [E("span", null, [r.value || v.value ? (k(), j(l, { key: 0, disabled: !P.value, class: "filter-item", type: "success", onClick: oe }, { default: w(() => a[2] || (a[2] = [pe(" 添加物料 ")])), _: 1, __: [2] }, 8, ["disabled"])) : W("", true)])]), _: 1 }, 8, ["disabled"])])]), g(c, { ref_key: "formRef", ref: C, model: p(s) }, { default: w(() => [g(Ae, { ref_key: "tableRef", ref: f, "basic-class": p(_), "bool-apply-purchase": G.value, "bool-party-a": r.value, fillableAmount: H.value, "max-height": p(te), noDetail: v.value }, null, 8, ["basic-class", "bool-apply-purchase", "bool-party-a", "fillableAmount", "max-height", "noDetail"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["basic-class", "edit", "show-total-amount", "total-amount"]), g(i, { ref_key: "drawerRef", ref: O, modelValue: S.value, "onUpdate:modelValue": a[1] || (a[1] = (d) => S.value = d), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: w(() => [P.value ? (k(), j(Be, { key: 0, ref_key: "matSpecRef", ref: o, modelValue: p(s).auxMatList, "onUpdate:modelValue": a[0] || (a[0] = (d) => p(s).auxMatList = d), "basic-class": p(_), "classify-ids": b.value.otherMaterialIds, "max-height": p(ee), "row-init-fn": le, "table-width": 430, visible: S.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "classify-ids", "max-height", "visible"])) : W("", true)]), _: 1 }, 8, ["modelValue"])])), [[h, p(U)]]);
  };
} }, Ke = be(Ce, [["__scopeId", "data-v-5858201d"]]);
export {
  Ke as default
};
