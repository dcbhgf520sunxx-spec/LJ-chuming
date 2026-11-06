import { ref as d } from "vue";
import { inject as re } from "vue";
import { computed as C } from "vue";
import { resolveComponent as A } from "vue";
import { openBlock as b } from "vue";
import { createBlock as h } from "vue";
import { withCtx as n } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as v } from "vue";
import { withDirectives as ce } from "vue";
import { createElementBlock as j } from "vue";
import { toDisplayString as ue } from "vue";
import { createCommentVNode as T } from "vue";
import { normalizeClass as me } from "vue";
import { ElMessage as de } from "element-plus";
import { ElPopover as pe } from "element-plus";
import { ElTag as fe } from "element-plus";
import { ElPopconfirm as be } from "element-plus";
import { ElTableColumn as _e } from "element-plus";
import { ElInput as ge } from "element-plus";
import { vLoading as we } from "element-plus";
import { _ as ye, jX as Ee, gt as Se, sQ as Ce, C6 as he, gG as O, C7 as ve, o as Te, G as Re, bl as c, i as R, cO as x, jl as w, iX as xe, B2 as Me, oz as Ve, xs as z, ib as B, B3 as ke, aR as Le, jG as H, k5 as G, k6 as q, k4 as Ne, ba as Ae, V as Oe, lP as Be } from "../../../../../../shared/runtime.js";
import Fe from "./material-unit-quantity-columns/index.vue.js";
import "./material-unit-quantity-columns/module/raw-mat.vue.js";
const Ie = { style: { "max-height": "200px", overflow: "auto", "min-height": "150px" } }, Pe = { key: 1, class: "footer" }, De = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false }, componentName: { type: [String, Number], default: void 0 }, journalId: { type: [String, Number], default: void 0 } }, emits: ["auditSuccess"], setup(K, { emit: Q }) {
  const X = d(), J = d(), M = d([]), V = d(), k = d({}), y = d(false), _ = d(), W = re("permission"), Y = d([...Ee, ["remark", "empty-text"]]), { CRUD: Z, crud: E, detail: t } = Se(), { baseUnit: f } = Ce(), ee = Q, F = K, I = C(() => {
    switch (t.outboundTypeSelection) {
      case O.OUTSOURCE.V:
        return ve;
      default:
        return he;
    }
  }), { maxHeight: ae } = Te({ mainBox: ".raw-mat-return-application-record-detail", extraBox: [".el-drawer__header", ".material-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => C(() => !E.detailLoading)), te = C(() => t && t.serialNumber ? `退库单：${t.serialNumber}` : "退库单");
  C(() => Re(W.showAmount)), Z.HOOK.beforeDetailLoaded = async (i, a) => {
    _.value = void 0, V.value = void 0, k.value = {};
    const u = [], p = [];
    (a.basicClass === c.STEEL_PLATE.V || a.basicClass & c.SECTION_STEEL.V) && a.list.forEach(async (s) => {
      if (s.boolReturns && R(s.list)) {
        await x(s.list);
        const m = await w(s.list, { toNum: true }, { mete: ["mete", "returnableMete", "singleMete", "singleReturnableMete", "singleReturnMete"] }), r = s.list.map((N) => N.source);
        await x(r);
        const L = await w(r, { toNum: true }, { mete: ["mete", "returnableMete", "singleMete", "singleReturnableMete", "singleReturnMete"] });
        u.push(m), p.push(L);
      }
    }), await Promise.all(p), await Promise.all(u), await x(a.list), await w(a.list, { toNum: true });
    const S = a.list.map((s) => s.source);
    await x(S), await w(S, { toNum: true }, { mete: ["mete", "returnableMete", "singleMete", "singleReturnableMete"] }), a.list.forEach((s) => {
      s.actualMete = s.mete;
    }), (a.basicClass === c.STEEL_PLATE.V || a.basicClass === c.SECTION_STEEL.V) && a.list.forEach(async (s) => {
      if (s.uid = s.id, s.boolReturns && R(s.list)) {
        let m = 0;
        s.list.forEach((r) => {
          r.pid = s.id, r.uid = r.id, r.singleReturnMete && (m += r.singleReturnMete);
        }), s.detailMete = xe(m, f.value[a.basicClass].weight.precision) * (s.quantity || 0), s.actualMete = s.detailMete;
      }
    });
  };
  function se(i, a, u) {
    k.value = i, V.value = i.source;
  }
  function le(i) {
    const a = t.basicClass && f.value && f.value[t.basicClass] ? f.value[t.basicClass].measure.precision : 0;
    return Ae(i, { props: [["quantity", a], "actualMete", "mete"] });
  }
  async function ie(i) {
    return i.list = await w(i.list, { toSmallest: true, toNum: true }), i;
  }
  async function P(i) {
    try {
      y.value = true;
      const a = Oe(t), u = await ie(a);
      if (i === B.REFUSE.V && !R(_.value)) {
        de.error("请输入审批意见");
        return;
      }
      const p = { approveRecordId: t.approveRecordId, decision: i, opinion: _.value };
      t.outboundTypeSelection === O.OUTSOURCE.V ? I.value(p, u) : await I.value(p), ee("auditSuccess");
    } catch (a) {
      console.log("退库(审批流)审核提交", a);
    } finally {
      y.value = false;
    }
  }
  async function oe(i) {
    i.loading = true;
    try {
      i.wmsApproveFlowDTOS = await Be(i.approveRecordId);
    } catch (a) {
      console.log(a, "获取失败");
    } finally {
      i.loading = false;
    }
  }
  return (i, a) => {
    const u = A("common-button"), p = pe, S = fe, s = be, m = _e, r = A("common-table"), L = ge, N = A("common-drawer"), ne = we;
    return b(), h(N, { ref_key: "drawerRef", ref: X, "before-close": e(E).cancelDetail, "content-loading": e(E).detailLoading, "show-close": true, title: te.value, visible: e(E).detailVisible, "custom-class": "raw-mat-return-application-record-detail", size: "100%" }, { titleAfter: n(() => [l(Me, { detail: e(t) }, null, 8, ["detail"])]), titleRight: n(() => {
      var o;
      return [l(p, { width: 400, placement: "bottom", trigger: "click", onShow: a[0] || (a[0] = (g) => oe(e(t))) }, { reference: n(() => [l(u, { size: "small" }, { default: n(() => a[5] || (a[5] = [v("查看审批记录")])), _: 1, __: [5] })]), default: n(() => [ce((b(), j("div", Ie, [l(Ve, { data: e(t).wmsApproveFlowDTOS }, null, 8, ["data"])])), [[ne, e(t).loading]])]), _: 1 }), e(R)(e(t).reviewStatus) && e(t).outboundTypeSelection === e(O).PRODUCE.V ? (b(), h(S, { key: 0, type: (o = e(z).V[e(t).reviewStatus]) == null ? void 0 : o.TAG, size: "large", style: { "margin-right": "10px" } }, { default: n(() => [v(ue(e(z).VL[e(t).reviewStatus]), 1)]), _: 1 }, 8, ["type"])) : T("", true), F.ApprovalFlag ? (b(), j("div", Pe, [l(s, { title: "确认通过", onConfirm: a[1] || (a[1] = (g) => P(e(B).PASS.V)) }, { reference: n(() => [l(u, { loading: y.value, class: "filter-item", size: "default", type: "success" }, { default: n(() => a[6] || (a[6] = [v("通过 ")])), _: 1, __: [6] }, 8, ["loading"])]), _: 1 }), l(s, { title: "确认驳回", onConfirm: a[2] || (a[2] = (g) => P(e(B).REFUSE.V)) }, { reference: n(() => [l(u, { loading: y.value, class: "filter-item", size: "default", type: "danger" }, { default: n(() => a[7] || (a[7] = [v(" 驳回 ")])), _: 1, __: [7] }, 8, ["loading"])]), _: 1 })])) : T("", true)];
    }), content: n(() => [l(ke, { "basic-class": e(t).basicClass, material: V.value, class: "material-info" }, null, 8, ["basic-class", "material"]), l(r, { ref_key: "tableRef", ref: J, data: e(t).list, "data-format": Y.value, "expand-row-keys": M.value, "max-height": e(ae), "summary-method": le, "default-expand-all": "", "highlight-current-row": "", "row-key": "id", "show-summary": "", onRowClick: se }, { default: n(() => [l(Le, { "expand-row-keys": M.value, "onUpdate:expandRowKeys": a[3] || (a[3] = (o) => M.value = o), data: e(t).list, fixed: "left", "row-key": "id" }, { default: n(({ row: o }) => [(e(t).basicClass === e(c).STEEL_PLATE.V || e(t).basicClass === e(c).SECTION_STEEL.V) && o.boolReturns ? (b(), h(r, { key: o.id, class: me(k.value.uid === o.uid ? "child-table" : ""), data: o.list, stripe: false, style: { margin: "10px 0" } }, { default: n(() => {
      var g, D, $, U;
      return [l(H, { "basic-class": o.basicClass }, { afterMaterialSn: n(() => [l(m, { key: "materialSnNew", "show-overflow-tooltip": true, label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 2 }, 1032, ["basic-class"]), l(G, { "basic-class": o.basicClass }, null, 8, ["basic-class"]), l(m, { label: `数量 (${(D = (g = e(f)[o.basicClass]) == null ? void 0 : g.measure) == null ? void 0 : D.unit})`, align: "center", prop: "singleQuantity", width: "110px" }, null, 8, ["label"]), l(m, { key: "singleReturnMete", label: `总重 (${(U = ($ = e(f)[o.basicClass]) == null ? void 0 : $.weight) == null ? void 0 : U.unit})`, align: "center", prop: "singleReturnMete", width: "120px" }, null, 8, ["label"]), l(q)];
    }), _: 2 }, 1032, ["class", "data"])) : T("", true), l(Ne, { "basic-class": o.basicClass, row: o, "show-batch-no": false, "show-graphics": "", "show-remark": "" }, null, 8, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"]), l(H, { "basic-class": e(t).basicClass, showTip: e(t).basicClass === e(c).STEEL_PLATE.V || e(t).basicClass === e(c).SECTION_STEEL.V }, { afterMaterialSn: n(() => [l(m, { key: "materialSnNew", "show-overflow-tooltip": true, label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 1 }, 8, ["basic-class", "showTip"]), l(G, { "basic-class": e(t).basicClass }, null, 8, ["basic-class"]), l(Fe, { "basic-class": e(t).basicClass, showTip: e(t).basicClass === e(c).STEEL_PLATE.V || e(t).basicClass === e(c).SECTION_STEEL.V }, null, 8, ["basic-class", "showTip"]), l(q, { "show-area": false, "show-monomer": false, "show-project": "" })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"]), F.ApprovalFlag ? (b(), h(L, { key: 0, modelValue: _.value, "onUpdate:modelValue": a[4] || (a[4] = (o) => _.value = o), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px" }, type: "textarea" }, null, 8, ["modelValue"])) : T("", true)]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, He = ye(De, [["__scopeId", "data-v-7e2788e8"]]);
export {
  He as default
};
