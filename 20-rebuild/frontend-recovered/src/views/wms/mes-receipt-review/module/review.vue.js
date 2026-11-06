import { ref as l } from "vue";
import { provide as xe } from "vue";
import { inject as ne } from "vue";
import { useStore as De } from "vuex";
import { computed as J } from "vue";
import { watch as Te } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as N } from "vue";
import { createVNode as r } from "vue";
import { withCtx as h } from "vue";
import { createBlock as y } from "vue";
import { unref as s } from "vue";
import { createTextVNode as R } from "vue";
import { toDisplayString as P } from "vue";
import { createCommentVNode as L } from "vue";
import { withDirectives as B } from "vue";
import { vShow as Ie } from "vue";
import { createElementVNode as v } from "vue";
import { isRef as Se } from "vue";
import { Fragment as Ce } from "vue";
import { ElMessageBox as Ae } from "element-plus";
import { ElTag as Ee } from "element-plus";
import { ElDivider as je } from "element-plus";
import { ElTableColumn as Me } from "element-plus";
import { ElCheckbox as Ne } from "element-plus";
import { vLoading as Re } from "element-plus";
import { d as Pe, g as Be, s as Ve } from "../../../../modules/mes-receipt-review-377f871a.js";
import { _ as He, jX as Ue, o as Qe, u as qe, b as ze, aI as Je, c as C, jN as c, i as k, Bj as ae, am as F, iX as W, ba as Fe } from "../../../../shared/runtime.js";
import We from "./print-table/index.vue.js";
import Xe from "./handle-detail-table.vue.js";
import Ke from "./outbound-handle-table.vue.js";
import Ge from "./submit-review.vue.js";
import Ye from "./receipt-list.vue.js";
import "./outbound-detail.vue.js";
import "./outbound-handling-form/index.vue.js";
import "./outbound-handling-form/module/steel-plate.vue.js";
import "./outbound-handling-form/components/common-form-item.vue.js";
import "./outbound-handling-form/components/produce-form.vue.js";
import "./outbound-handling-form/components/common-material-info.vue.js";
import "./outbound-handling-form/module/section-steel.vue.js";
const Ze = { style: { display: "flex" } }, $e = { style: { width: "39%" } }, et = { style: { float: "right" } }, tt = { style: { width: "60%" } }, it = { key: 1, class: "my-code" }, nt = { __name: "review", props: { modelValue: { type: Boolean, default: false }, data: { type: Object, default: () => ({}) }, showType: { type: String, default: "detail" } }, emits: ["refresh", "update:modelValue"], setup(x, { emit: oe }) {
  const X = oe, ue = x, le = l(), A = l(false), E = l({}), V = l([]), m = l([]);
  xe("handleDetailList", m);
  const se = l(false), O = l(), _ = l({}), b = ne("mainCurrentRow"), K = ne("handlingData"), H = l(false), p = l([]), U = l({ projectNum: 0, receiptNum: 0 }), re = De(), ce = l([]), G = l(false), Y = l({}), j = l(false), D = l(false), de = J(() => !(m.value.findIndex((i) => i.currentOutboundQuantity > 0) > -1 || O.value)), me = l([...Ue, ["pickingAmount", ["to-fixed-field", "accountingPrecision"]], ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), pe = J(() => "明细"), { maxHeight: T } = Qe({ mainBox: ".raw-mat-application-review-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => J(() => !A.value)), { visible: I, handleClose: Q } = qe({ emit: X, props: ue, closeHook: ye });
  Te(I, async (i) => {
    i && (_.value = {}, p.value = [], K.value.forEach((e) => {
      p.value.push(e);
    }), q());
  }, { immediate: true });
  function ge(i) {
    p.value.splice(i, 1), q();
  }
  function fe() {
    p.value = [], K.value.forEach((i) => {
      p.value.push(i);
    }), q();
  }
  async function q() {
    O.value = false, E.value = {};
    const i = [];
    U.value.receiptNum = p.value.length || 0, p.value.forEach((e) => {
      i.includes(e.projectId) || i.push(e.projectId);
    }), U.value.projectNum = i.length || 0, await he();
  }
  async function he() {
    V.value = [], m.value = [];
    const i = p.value.map((e) => e.id);
    if (!ze(i)) try {
      A.value = true;
      const e = JSON.parse(JSON.stringify(await Pe({ ids: i })));
      e == null || e.forEach((t) => {
        var u;
        t.uid = Je(), t.basicClass = b.value.basicClass, t.measureUnit = b.value.measureUnit, t.transactDisabled = (+t.volume || 0) + (+t.nowMete || 0) >= (+t.pickingAmount || 0) * 1e3, t.pickingAmount = C(t.pickingAmount, "kg", c.weight.unit, c.weight.precision), t.unit = c.weight.unit, t.accountingUnit = c.weight.unit, t.accountingPrecision = c.weight.precision, t.volume = C(t.volume, "g", c.weight.unit, c.weight.precision), t.nowMete && (t.nowMete = C(t.nowMete, "g", c.weight.unit, c.weight.precision)), t.currentOutBoundOptions = [], t.currentOutboundQuantity = void 0, t.currentOutboundMete = void 0, t.pickingList = [];
        const n = [];
        (u = t.wmsPickingDetailDTOList) == null || u.map((o) => {
          var d;
          const a = p.value.find((w) => w.id === o.pickingId);
          o.project = (a == null ? void 0 : a.project) || {}, o.mesWorkshop = (a == null ? void 0 : a.mesWorkshop) || {}, o.materialType = a == null ? void 0 : a.materialType, o.transactDisabled = (+o.volume || 0) + (+o.nowMete || 0) >= (+o.pickingAmount || 0) * 1e3, o.accountingUnit = c.weight.unit, o.accountingPrecision = c.weight.precision, o.unit = c.weight.unit, o.pickingAmount = C(o.pickingAmount, "kg", c.weight.unit, c.weight.precision), o.basicClass = b.value.basicClass, o.measureUnit = b.value.measureUnit, o.volume = C(o.volume, "g", c.weight.unit, c.weight.precision), n.includes(o.pickingId) || n.push(o.pickingId), k(o.wmsPickingDetailDTOList) && (o.id = o.id || ((d = o.wmsPickingDetailDTOList) == null ? void 0 : d[0].id), o.pickingId = o.pickingId || o.wmsPickingDetailDTOList[0].pickingId, o.taskOrderId = o.taskOrderId || o.wmsPickingDetailDTOList[0].taskOrderId);
        });
        for (let o = 0; o < n.length; o++) {
          const a = { pickingId: n[o], taskOrderId: void 0, taskOrderNumber: void 0, pickingAmount: 0, pickingArea: 0, pickingLength: 0, handlingArea: 0, handlingLength: 0, volume: 0 }, d = t.wmsPickingDetailDTOList.find((w) => w.pickingId === n[o]);
          a.pickingDetailIds = d.id, a.pickingAmount = d.pickingAmount, a.pickingArea = d.pickingArea, a.pickingLength = d.pickingLength, a.volume = d.volume, a.handlingArea = d.handlingArea, a.handlingLength = d.handlingLength, a.taskOrderId = d.taskOrderId, a.taskOrderNumber = d.taskOrderNumber, t.pickingList.push(a), t.pickingList.forEach((w) => {
            w.currentMete = 0, w.currentArea = 0, w.currentLength = 0, w.materialObj = {};
          });
        }
      }), V.value = JSON.parse(JSON.stringify(e)), m.value = JSON.parse(JSON.stringify(e));
    } catch (e) {
      console.log("加载失败", e);
    } finally {
      A.value = false;
    }
  }
  function we(i) {
    const e = m.value.find((t) => t.uid === i.uid);
    if (k(e)) {
      e.currentOutboundQuantity = (e.currentOutboundQuantity || 0) + i.outboundQuantity, e.currentOutboundMete = W((e.currentOutboundMete || 0) + i.outboundMete, c.weight.precision), e.currentOutboundArea = (e.currentOutboundArea || 0) + i.currentArea, e.currentOutboundLength = (e.currentOutboundLength || 0) + i.currentLength;
      const t = e.currentOutBoundOptions.find((n) => n.materialId === i.materialId);
      k(t) ? (t.outboundQuantity += i.outboundQuantity, t.outboundMete += i.outboundMete, t.outboundMete = W(t.outboundMete, c.weight.precision)) : e.currentOutBoundOptions.push(i);
    }
  }
  function be() {
    G.value = false, Q();
  }
  function ye() {
  }
  function ve(i) {
    E.value = i;
  }
  async function ke() {
    _.value = {};
    const i = [], e = { completePickingDetailIds: [], pickingIds: [] };
    if (m.value.forEach((t) => {
      var n;
      k(t.currentOutBoundOptions) && i.push({ pickingDetailIds: t.wmsPickingDetailDTOList.map((u) => u.id), materialType: b.value.materialType, materialDTOParams: t.currentOutBoundOptions.map((u) => ({ materialId: u.materialId, quantity: u.outboundQuantity })) }), (n = t.wmsPickingDetailDTOList) == null || n.forEach((u) => {
        e.completePickingDetailIds.includes(u.id) || e.completePickingDetailIds.push(u.id), e.pickingIds.includes(u.pickingId) || e.pickingIds.push(u.pickingId);
      });
    }), k(i)) {
      D.value = true;
      try {
        const t = JSON.parse(JSON.stringify(await Be(i)));
        _.value = t, k(_.value) && _.value.wmsPickingDetailDTOList.map((n) => {
          const u = p.value.find((o) => o.id === n.pickingId);
          return n.basicClass = b.value.basicClass, n.materialType = u == null ? void 0 : u.materialType, n.basicClass === F.STEEL_PLATE.V && (n.transactDisabled = (+n.volume || 0) + (+n.nowMete || 0) >= (+n.pickingAmount || 0) * 1e3), n.accountingUnit = c.weight.unit, n.accountingPrecision = c.weight.precision, n.unit = c.weight.unit, n.pickingAmount = C(n.pickingAmount, "kg", c.weight.unit, c.weight.precision), n.volume = C(n.volume, "g", c.weight.unit, c.weight.precision), n.nowMete = C(n.nowMete, "g", c.weight.unit, c.weight.precision), n.realCurrent = true, (O.value || (b.value.basicClass === F.STEEL_PLATE.V ? n.transactDisabled : (n.handlingLength || 0) + (n.nowLength || 0) >= (n.pickingLength || 0))) && (n.isTransactStatus = true), n;
        }), j.value = true;
      } catch (t) {
        console.log(t);
      } finally {
        D.value = false;
      }
    } else if (O.value) {
      await Ae.confirm("确认全部齐套吗?", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), D.value = true;
      try {
        await Ve(e), Z();
      } catch (t) {
        console.log(t);
      } finally {
        D.value = false;
      }
    } else j.value = true;
  }
  function Oe(i) {
    const e = JSON.parse(JSON.stringify(i));
    Y.value = e;
    const t = m.value.find((n) => n.uid === i.uid);
    k(t) && (t.currentOutboundQuantity = (t.currentOutboundQuantity || 0) - i.outboundQuantity, t.currentOutboundMete = W((t.currentOutboundMete || 0) - i.outboundMete, c.weight.precision), t.currentOutboundArea = (t.currentOutboundArea || 0) - i.currentArea, t.currentOutboundLength = (t.currentOutboundLength || 0) - i.currentLength);
  }
  async function Z() {
    X("refresh"), await re.dispatch("approval_list/fetchApprovalNum"), Q();
  }
  function _e(i) {
    return Fe(i, { props: ["quantity", ["mete", c.weight.precision], ["pickingAmount", c.weight.precision]] });
  }
  return (i, e) => {
    const t = Ee, n = M("common-button"), u = je, o = M("table-cell-tag"), a = Me, d = M("common-table"), w = Ne, Le = M("common-drawer"), z = Re;
    return f(), N(Ce, null, [r(Le, { ref_key: "drawerRef", ref: le, modelValue: s(I), "onUpdate:modelValue": e[2] || (e[2] = (g) => Se(I) ? I.value = g : null), "before-close": s(Q), title: pe.value, "show-close": true, "close-on-click-modal": false, size: "100%", "custom-class": "raw-mat-application-review-form" }, { titleAfter: h(() => {
      var g;
      return [x.data.transactStatus ? (f(), y(t, { key: 0, type: (g = s(ae).V[x.data.transactStatus]) == null ? void 0 : g.T, size: "default" }, { default: h(() => [R(P(s(ae).VL[x.data.transactStatus]), 1)]), _: 1 }, 8, ["type"])) : L("", true), B(r(s(We), { "api-key": "wmsRmMesOutboundReceipt", params: [x.data.id], size: "default", type: "warning", class: "filter-item", isPrint: G.value, onSuccess: be }, null, 8, ["params", "isPrint"]), [[Ie, false]])];
    }), titleRight: h(() => e[5] || (e[5] = [])), content: h(() => [B((f(), N("div", Ze, [v("div", $e, [v("div", null, [r(t, { style: { cursor: "pointer" }, size: "default", onClick: e[0] || (e[0] = (g) => {
      H.value = true;
    }) }, { default: h(() => [R("项目数（个）：" + P(U.value.projectNum) + " | 工单数（个）：" + P(p.value.length), 1)]), _: 1 }), de.value ? (f(), y(n, { key: 0, type: "warning", size: "default", onClick: fe, style: { float: "right" } }, { default: h(() => e[6] || (e[6] = [R("还原")])), _: 1, __: [6] })) : L("", true)]), B((f(), N("div", null, [r(u, null, { default: h(() => e[7] || (e[7] = [v("span", { class: "title" }, "领用明细", -1)])), _: 1, __: [7] }), B((f(), y(d, { data: V.value, "data-format": me.value, "max-height": (s(T) - 120) / 2, "highlight-current-row": "", "show-summary": "", "summary-method": _e, "expand-row-keys": ce.value, "row-key": "id", onCurrentChange: ve }, { default: h(() => [r(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }, { default: h(({ row: { sourceRow: g }, $index: S }) => {
      var $, ee, te, ie;
      return [($ = m.value[S]) != null && $.volume || (ee = m.value[S]) != null && ee.currentOutboundMete ? (f(), y(o, { key: 0, show: !!((te = m.value[S]) != null && te.volume) && !!((ie = m.value[S]) != null && ie.currentOutboundMete), name: "办理" }, null, 8, ["show"])) : L("", true), v("span", null, P(S + 1), 1)];
    }), _: 1 }), r(a, { key: "pickingType", align: "left", label: "领料类型", prop: "pickingType", "show-overflow-tooltip": "" }), s(b).basicClass === s(F).SECTION_STEEL.V ? (f(), y(a, { key: "specification", label: "规格", align: "center", prop: "specification", "show-overflow-tooltip": "", "min-width": "120px" })) : L("", true), s(b).basicClass === s(F).STEEL_PLATE.V ? (f(), y(a, { key: "thick", label: "厚度(mm)", align: "center", prop: "thick", "show-overflow-tooltip": "", width: "100px" })) : L("", true), r(a, { key: "material", align: "left", label: "材质", prop: "material", "show-overflow-tooltip": "" }), r(a, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", width: "80" }), r(a, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": "", "min-width": "80px" }), r(a, { key: "unit", prop: "unit", label: "核算单位", align: "center", width: "80px" }), r(a, { key: "pickingAmount", prop: "pickingAmount", label: "领料量", align: "center", "show-overflow-tooltip": "", "min-width": "80px" })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])), [[z, se.value]]), r(u, null, { default: h(() => e[8] || (e[8] = [v("span", { class: "title" }, "办理明细", -1)])), _: 1, __: [8] }), s(I) ? (f(), y(Xe, { key: 0, list: m.value, maxHeight: (s(T) - 120) / 2, style: { "margin-top": "10px" }, onDeleteRowSuccess: Oe }, { extra: h(() => [v("div", et, [r(w, { modelValue: O.value, "onUpdate:modelValue": e[1] || (e[1] = (g) => O.value = g), label: "齐套", style: { "margin-right": "10px" } }, null, 8, ["modelValue"]), r(n, { type: "primary", size: "default", style: { "marin-left": "10px" }, onClick: ke }, { default: h(() => e[9] || (e[9] = [R("出库确认")])), _: 1, __: [9] })])]), _: 1 }, 8, ["list", "maxHeight"])) : L("", true)])), [[z, A.value]])]), e[10] || (e[10] = v("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 130px)" } }, null, -1)), v("div", tt, [s(k)(E.value) ? (f(), y(Ke, { key: 0, currentRow: E.value, onOutboundSuccess: we, deleteRowObj: Y.value, maxHeight: s(T) - 150 }, null, 8, ["currentRow", "deleteRowObj", "maxHeight"])) : (f(), N("div", it, "*点击左表领用明细查看"))])])), [[z, D.value]])]), _: 1 }, 8, ["modelValue", "before-close", "title"]), r(s(Ge), { modelValue: j.value, "onUpdate:modelValue": e[3] || (e[3] = (g) => j.value = g), submitObj: _.value, handleDetailList: m.value, onSuccess: Z, maxHeight: s(T) }, null, 8, ["modelValue", "submitObj", "handleDetailList", "maxHeight"]), r(Ye, { modelValue: H.value, "onUpdate:modelValue": e[4] || (e[4] = (g) => H.value = g), list: p.value, maxHeight: s(T), onDeleteReceipt: ge }, null, 8, ["modelValue", "list", "maxHeight"])], 64);
  };
} }, yt = He(nt, [["__scopeId", "data-v-7d4d0376"]]);
export {
  yt as default
};
