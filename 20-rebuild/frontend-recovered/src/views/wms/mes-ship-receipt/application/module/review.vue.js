import { ref as r } from "vue";
import { provide as re } from "vue";
import { inject as j } from "vue";
import { useStore as le } from "vuex";
import { computed as B } from "vue";
import { watch as se } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as O } from "vue";
import { createVNode as u } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as c } from "vue";
import { toDisplayString as L } from "vue";
import { unref as l } from "vue";
import { createTextVNode as de } from "vue";
import { withDirectives as ce } from "vue";
import { isRef as me } from "vue";
import { Fragment as pe } from "vue";
import { ElMessage as U } from "element-plus";
import { ElBadge as be } from "element-plus";
import { ElDivider as fe } from "element-plus";
import { ElTableColumn as he } from "element-plus";
import { vLoading as we } from "element-plus";
import { d as ve } from "../../../../../modules/mes-ship-receipt-ae6ae43f.js";
import { _ as ye, o as ge, u as _e, b as W, i as m, z as Oe, ai as C, cS as xe, iX as ke, ba as Re } from "../../../../../shared/runtime.js";
import Se from "./outbound-handle-table.vue.js";
import De from "./submit-review.vue.js";
import Be from "./outbound-detail.vue.js";
import "./outbound-handling-form/index.vue.js";
import "./outbound-handling-form/module/steel-plate.vue.js";
import "./outbound-handling-form/components/common-form-item.vue.js";
import "./outbound-handling-form/components/produce-form.vue.js";
import "./outbound-handling-form/components/common-material-info.vue.js";
import "./outbound-handling-form/module/section-steel.vue.js";
import "./outbound-handling-form/module/steel-coil.vue.js";
import "./outbound-handling-form/module/aux-mat.vue.js";
import "./outbound-handling-form/module/gas.vue.js";
import "./outbound-handling-form/module/other.vue.js";
const Me = { style: { display: "flex" } }, Ce = { style: { width: "36%" } }, Ee = ["onClick"], Ie = { key: 1 }, He = { style: { width: "63%" } }, Te = { __name: "review", props: { modelValue: { type: Boolean, default: false }, data: { type: Object, default: () => ({}) }, showType: { type: String, default: "detail" } }, emits: ["refresh", "update:modelValue"], setup(A, { emit: V }) {
  const E = V, F = A, J = r(), h = r({}), x = r(false), P = r("handled"), w = r(false), b = r({}), s = r([]);
  re("handleDetailList", s);
  const q = j("handlingData"), I = j("globalProject"), p = r([]), z = le(), $ = r([]), v = r({}), k = r(false), R = B(() => {
    const e = [];
    return s.value.forEach((t) => {
      var o;
      (o = t.currentOutBoundOptions) == null || o.forEach((n) => {
        e.push(n);
      });
    }), e;
  }), K = B(() => "发运冻结办理"), { maxHeight: S } = ge({ mainBox: ".raw-mat-application-review-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => B(() => !w.value)), { visible: y, handleClose: H } = _e({ emit: E, props: F, closeHook: Y });
  se(y, async (e) => {
    e && (b.value = {}, p.value = [], v.value = {}, h.value = {}, X());
  }, { immediate: true });
  async function X() {
    s.value = [];
    const e = q.value.map((t) => t.id);
    if (!W(e)) try {
      w.value = true;
      const t = await ve({ ids: e }), o = [];
      t.forEach((n) => {
        o.push({ ...n, uid: n.id, currentOutBoundOptions: [], currentOutboundQuantity: void 0, currentOutboundMete: void 0 });
      }), s.value = JSON.parse(JSON.stringify(o));
    } catch (t) {
      console.log(t);
    } finally {
      w.value = false;
    }
  }
  function G(e) {
    const t = s.value.find((o) => o.uid === e.uid);
    if (m(t)) {
      const o = t.currentOutBoundOptions.find((n) => n.materialId === e.materialId && C(e.mesWorkshopId, n.mesWorkshopId) && C(e.recipientId, n.recipientId) && C(e.remark, n.remark));
      m(o) ? (m(e.outboundQuantity) && (o.outboundQuantity += e.outboundQuantity), o.outboundMete += e.outboundMete) : (e.currentTimeId = e.materialId + "" + (/* @__PURE__ */ new Date()).getTime(), t.currentOutBoundOptions.push(e)), T(t);
    }
  }
  function T(e) {
    e.currentOutboundQuantity = 0, e.currentOutboundMete = 0, m(e.currentOutBoundOptions) && e.currentOutBoundOptions.forEach((t) => {
      e.currentOutboundQuantity = e.currentOutboundQuantity + (t.outboundQuantity || 0), e.outboundUnitType === xe.MEASURE.V ? e.currentOutboundMete = e.currentOutboundQuantity && ke(e.outboundQuantity / e.operableQuantity * e.operableMete, e.accountingPrecision) || 0 : e.currentOutboundMete = e.currentOutboundMete + (t.outboundMete || 0);
    });
  }
  function Y() {
    b.value = {}, p.value = [], v.value = {}, h.value = {};
  }
  function Z(e) {
    if (b.value = {}, m(e)) {
      if (e != null && e.boolUnderReview) {
        U.error("该配套件存在正在审核出库数据，请审核后再办理！");
        return;
      }
      b.value = e;
    }
  }
  function ee() {
    p.value = [];
    const e = [];
    if (s.value.forEach((t) => {
      var o;
      (o = t.currentOutBoundOptions) == null || o.forEach((n) => {
        e.push(n);
      });
    }), W(e)) {
      U.error("本次出库明细不能为空");
      return;
    }
    p.value = e, k.value = true;
  }
  function te(e, t) {
    x.value = true, h.value = e, P.value = t;
  }
  function N(e) {
    var g, i;
    const t = JSON.parse(JSON.stringify(e));
    v.value = t;
    const o = s.value.find((f) => f.uid === e.uid), n = (g = o == null ? void 0 : o.currentOutBoundOptions) == null ? void 0 : g.findIndex((f) => f.currentTimeId === e.currentTimeId);
    m(o) && n > -1 && ((i = o == null ? void 0 : o.currentOutBoundOptions) == null || i.splice(n, 1)), T(o);
  }
  function oe(e, t) {
    p.value.splice(t, 1), N(e);
  }
  async function ne() {
    E("refresh"), await z.dispatch("approval_list/fetchApprovalNum"), H();
  }
  function ue(e) {
    return Re(e, { props: ["quantity", "mete", ["pickingAmount", 3]] });
  }
  return (e, t) => {
    const o = M("common-button"), n = be, g = fe, i = he, f = M("common-table"), ae = M("common-drawer"), ie = we;
    return _(), O(pe, null, [u(ae, { ref_key: "drawerRef", ref: J, modelValue: l(y), "onUpdate:modelValue": t[1] || (t[1] = (a) => me(y) ? y.value = a : null), "before-close": l(H), title: K.value, "show-close": true, "close-on-click-modal": false, size: "100%", "custom-class": "raw-mat-application-review-form" }, { titleAfter: d(() => [c("span", null, "项目名称:" + L(l(m)(l(I)) ? l(Oe)(l(I)) : "-"), 1)]), titleRight: d(() => {
      var a, D;
      return [u(n, { value: (a = R.value) == null ? void 0 : a.length, max: 99, hidden: ((D = R.value) == null ? void 0 : D.length) < 1 }, { default: d(() => {
        var Q;
        return [u(o, { type: "primary", onClick: ee, disabled: ((Q = R.value) == null ? void 0 : Q.length) < 1 }, { default: d(() => t[3] || (t[3] = [de("发运领用预览列表")])), _: 1, __: [3] }, 8, ["disabled"])];
      }), _: 1 }, 8, ["value", "hidden"])];
    }), content: d(() => [c("div", Me, [c("div", Ce, [t[5] || (t[5] = c("div", { class: "title-left" }, "配套件列表", -1)), ce((_(), O("div", null, [u(g, null, { default: d(() => t[4] || (t[4] = [c("span", { class: "title" }, "领用明细", -1)])), _: 1, __: [4] }), u(f, { data: s.value, "max-height": l(S) - 120, "highlight-current-row": "", "show-summary": "", showEmptySymbol: false, "return-source-data": "", "summary-method": ue, "expand-row-keys": $.value, "row-key": "id", onCurrentChange: Z }, { default: d(() => [u(i, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), u(i, { prop: "name", key: "name", label: "名称", align: "center", "min-width": "100", "show-overflow-tooltip": true }), u(i, { "show-overflow-tooltip": true, prop: "specification", key: "specification", label: "规格", align: "center", "min-width": "120px" }), u(i, { "show-overflow-tooltip": true, prop: "accountingUnit", key: "accountingUnit", label: `核算
单位`, align: "center", width: "60px" }), u(i, { "show-overflow-tooltip": true, prop: "mete", key: "mete", label: "核算量", align: "center", "min-width": "80px" }), u(i, { "show-overflow-tooltip": true, prop: "outboundWeight", key: "outboundWeight", label: "已出库量", align: "center", "min-width": "80px" }), u(i, { "show-overflow-tooltip": true, prop: "actualCanOutWarehouseWeight", key: "actualCanOutWarehouseWeight", label: "可出库量", align: "center", "min-width": "80px" }), u(i, { "show-overflow-tooltip": true, prop: "currentOutboundMete", key: "currentOutboundMete", label: "本次办理量", align: "center", "min-width": "80px" }, { default: d(({ row: a }) => [a.currentOutboundMete ? (_(), O("span", { key: 0, style: { cursor: "pointer", color: "#409eff" }, onClick: (D) => te(a, "current") }, L(a.currentOutboundMete), 9, Ee)) : (_(), O("span", Ie, "-"))]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "expand-row-keys"]), u(Be, { outboundListCurrentRow: h.value, modelValue: x.value, "onUpdate:modelValue": t[0] || (t[0] = (a) => x.value = a), onDeleteRow: N }, null, 8, ["outboundListCurrentRow", "modelValue"])])), [[ie, w.value]])]), t[6] || (t[6] = c("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 130px)" } }, null, -1)), c("div", He, [u(Se, { currentRow: b.value, onOutboundSuccess: G, deleteRowObj: v.value, maxHeight: l(S) - 150 }, null, 8, ["currentRow", "deleteRowObj", "maxHeight"])])])]), _: 1 }, 8, ["modelValue", "before-close", "title"]), u(l(De), { modelValue: k.value, "onUpdate:modelValue": t[2] || (t[2] = (a) => k.value = a), submitData: p.value, onSuccess: ne, maxHeight: l(S), onDeleteSubmitData: oe }, null, 8, ["modelValue", "submitData", "maxHeight"])], 64);
  };
} }, Ge = ye(Te, [["__scopeId", "data-v-d1f7f2c3"]]);
export {
  Ge as default
};
