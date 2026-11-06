import { useStore as Ge } from "vuex";
import { computed as I } from "vue";
import { ref as C } from "vue";
import { inject as Xe } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as c } from "vue";
import { createBlock as f } from "vue";
import { createSlots as Je } from "vue";
import { unref as l } from "vue";
import { withCtx as o } from "vue";
import { createElementBlock as O } from "vue";
import { Fragment as x } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as u } from "vue";
import { createTextVNode as k } from "vue";
import { createCommentVNode as g } from "vue";
import { toDisplayString as b } from "vue";
import { isRef as Ke } from "vue";
import { ElMessage as ne } from "element-plus";
import { ElDatePicker as Ze } from "element-plus";
import { ElPopconfirm as et } from "element-plus";
import { ElTableColumn as tt } from "element-plus";
import { ElTooltip as at } from "element-plus";
import { ElInput as lt } from "element-plus";
import { ElForm as it } from "element-plus";
import { _ as nt, yX as ot, gG as s, jY as st, zO as ut, zQ as rt, Ap as ct, Aq as dt, Ar as pt, zR as mt, zS as ht, As as ft, jX as gt, qS as yt, D as oe, o as vt, u as bt, jP as _t, bR as J, i as R, cO as Tt, jl as se, G as K, kD as B, xT as S, aR as Et, k4 as Vt, jG as Ct, k5 as Ot, cS as z, fv as Ut, z as wt, aV as It, xP as Rt, cy as St, bD as Pt, p as Dt, bl as P, aw as kt, yQ as At, sT as ue, sU as Mt, iX as $, cV as Nt, zP as xt, ba as Wt, jN as Z } from "../../../../../../../../../shared/runtime.js";
const jt = { key: 0 }, qt = { class: "batch-set-info child-mr-7" }, Lt = { key: 0 }, Bt = { style: { color: "brown" } }, zt = { style: { color: "#3a8ee6" } }, $t = { key: 1 }, Ft = { key: 1 }, Ht = { style: { width: "100%", "text-overflow": "ellipsis", "white-space": "nowrap", overflow: "hidden" } }, Qt = { key: 1 }, Yt = { __name: "list", props: { visible: { type: Boolean, default: false } }, emits: ["refresh", "update:visible"], setup(re, { emit: ce }) {
  const { lastTime: F } = ot();
  function ee(e) {
    return R(F.value) && F.value.endTime ? e.getTime() < Number(F.value.endTime) + 1 * 1e3 || e.getTime() > (/* @__PURE__ */ new Date()).getTime() : e.getTime() > (/* @__PURE__ */ new Date()).getTime();
  }
  const de = Ge(), H = ce, pe = re, me = /* @__PURE__ */ new Map([["outboundTime", null]]), te = I(() => {
    var e;
    return ((e = d.value.list) == null ? void 0 : e.findIndex((a) => a.isEdit)) > -1;
  }), n = C(s.PRODUCE.V), { outboundCfg: Q, selfOutboundTypeOptions: Y, produceOutboundEditConf: _ } = st(), he = (e, a) => {
    var p;
    return (p = Q.value) != null && p.productionOutBoundUserIsRequired && _.value.recipient && n.value === s.PRODUCE.V ? !!e : true;
  }, fe = (e, a) => _.value.mesWorkshop && n.value === s.PRODUCE.V ? !!e : true, ge = (e, a) => a.measureUnit && R(a.measurePrecision && a.outboundUnitType === z.MEASURE.V) ? !!e : true, ye = (e, a) => !!e, ae = I(() => _.value.recipient || _.value.mesWorkshop || _.value.quantity || _.value.project), ve = { quantity: [{ validator: ge, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: ye, message: "核算量必须大于0", trigger: "blur" }], recipientId: [{ validator: he, message: "请选择领用人", trigger: "change" }], workshopId: [{ validator: fe, message: "请选择生产车间", trigger: "change" }], outboundTime: [{ required: true, message: "请选择出库时间", trigger: "change" }] }, { tableValidate: be, cleanUpData: _e, wrongCellMask: Te } = kt({ rules: ve, ditto: me }), G = Xe("permission"), Ee = C(), y = C(false), A = C(false), W = C([]), d = C({}), j = C(0), q = C(), Ve = I(() => ut);
  function Ce(e) {
    const a = e.workshop ? e.workshop.name : void 0, p = e.warehouse ? e.warehouse.name : e.warehouseName;
    return a ? a + "【" + p + "】" : p;
  }
  const Oe = I(() => {
    switch (n.value) {
      case s.OUTSOURCE.V:
        return ct;
      default:
        return rt;
    }
  }), Ue = I(() => {
    switch (n.value) {
      case s.PRODUCE.V:
        return mt;
      case s.FOR_SALE.V:
        return pt;
      default:
        return dt;
    }
  }), we = I(() => {
    switch (n.value) {
      case s.OUTSOURCE.V:
        return ft;
      default:
        return ht;
    }
  }), Ie = I(() => y.value), Re = C([...gt, ["outboundAddress", ["parse-enum", yt]], ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["sellUnitPrice", ["to-thousand", oe.YUAN]], ["sellAmount", ["to-thousand", oe.YUAN]], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), { maxHeight: Se } = vt({ mainBox: ".raw-mat-application-review-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => I(() => !A.value)), { visible: X, handleClose: Pe } = bt({ emit: H, props: pe, field: "visible", showHook: De, closeHook: ke });
  function De() {
    Ae(), M();
  }
  function ke() {
    j.value && H("refresh");
  }
  function Ae() {
    A.value = false, y.value = false, y.value = false, W.value = [], d.value = {};
  }
  const T = C({});
  async function Me(e) {
    e.materialOutboundMode === At.HALF.V && (e.basicClass === P.STEEL_PLATE.V || e.basicClass === P.SECTION_STEEL.V) ? (e.basicClass === P.STEEL_PLATE.V && (e.theoryWeight = await ue({ classifyId: e.classifyId, name: e.classifyFullName, length: e.length, width: e.width, thickness: e.thickness })), e.basicClass === P.SECTION_STEEL.V && (e.theoryWeight = await Mt({ length: e.length, unitWeight: e.unitWeight })), e.theoryTotalWeight = $(e.theoryWeight * e.quantity, e.accountingPrecision || 0), e.basicClass === P.STEEL_PLATE.V && (e.actualTheoryWeight = e.theoryTotalWeight), e.mete = e.theoryTotalWeight) : (e.basicClass === P.STEEL_PLATE.V && (e.theoryWeight = await ue({ classifyId: e.classifyId, name: e.classifyFullName, length: e.length, width: e.width, thickness: e.thickness }), e.theoryTotalWeight = $(e.theoryWeight * e.quantity, e.accountingPrecision || 0), e.actualTheoryWeight = e.theoryTotalWeight), e.mete = $(e.quantity / e.originQuantity * e.originMete, e.accountingPrecision));
  }
  function Ne(e) {
    e.measureUnit && e.measurePrecision && (e.quantity = $(e.mete / e.originMete * e.originQuantity, e.measurePrecision));
  }
  function xe(e) {
    e.isEdit = true;
  }
  async function We(e) {
    var p, U, i, E, m;
    let a = "";
    ((U = (p = e.materialInventoryDTO) == null ? void 0 : p.project) != null && U.id || (i = e.materialInventoryDTO) != null && i.projectId || e.basicClass & Nt) && (a = "项目、");
    try {
      if (!e.recipientId && ((E = Q.value) != null && E.productionOutBoundUserIsRequired) || a && !e.projectId || !e.workshopId || !e.mete || !e.outboundTime) {
        const D = (m = Q.value) != null && m.productionOutBoundUserIsRequired ? "核算量、" + a + "领用车间、领用人、出库时间必填" : "核算量、" + a + "领用车间、出库时间必填";
        ne.error(D);
        return;
      }
      y.value = true;
      const r = JSON.parse(JSON.stringify(e));
      await se(r, { basicClass: r.basicClass, measureUnit: r.measureUnit, measurePrecision: r.measurePrecision, accountingUnit: r.accountingUnit, accountingPrecision: r.accountingPrecision, toNum: true, toSmallest: true }, { quantity: ["quantity"], mete: ["mete", "actualTheoryWeight"] });
      const w = { id: r.outboundId, deleteDetailIds: [r.id], list: [{ materialId: r.materialId, workshopId: r.workshopId, outboundUnit: r.outboundUnit, outboundUnitPrecision: r.outboundUnitPrecision, projectId: r.projectId, materialOutboundMode: r.materialOutboundMode, halfMode: r.halfMode, halfSize: r.halfSize, outboundTypeSelection: n.value, remark: r.remark, quantity: r.outboundUnitType === z.MEASURE.V ? r.quantity : r.mete, boolPartyA: false, outboundTime: r.outboundTime, recipientId: r.recipientId, actualTheoryWeight: r.actualTheoryWeight }] };
      await xt(w), await M(), e.isEdit = false, H("refresh");
    } catch (r) {
      console.log("删除", r);
    } finally {
      y.value = false;
    }
  }
  async function M() {
    try {
      A.value = true, T.value = {};
      const e = [], a = await Ve.value({ boolPartyA: false, outboundTypes: Y.value.map((p) => p.V) || [] });
      Y.value.forEach((p) => {
        T.value[p.V] = {};
      }), a.forEach(async (p) => {
        var U;
        if (T.value[p.outboundTypeSelection] = p, p.outboundTypeSelection === s.FOR_SALE.V && p.list.forEach((i) => {
          var E;
          i.branchCompany = i.outboundDetailSellDTO.branchCompany, i.inputMete = i.outboundDetailSellDTO.inputMete, i.invoiceType = i.outboundDetailSellDTO.invoiceType, i.sellAmount = i.outboundDetailSellDTO.sellAmount, i.sellUnitPrice = i.outboundDetailSellDTO.sellUnitPrice, i.taxRate = i.outboundDetailSellDTO.taxRate, i.weightMeasurementMode = i.outboundDetailSellDTO.weightMeasurementMode, i.purchaser = (E = i.outboundDetailSellDTO) == null ? void 0 : E.purchaser, i.basicClass & _t.STEEL.V && (i.theoryTotalWeight = i.weightMeasurementMode === J.THEORY.V ? i.inputMete : null, i.weighingWeight = i.weightMeasurementMode === J.OVERWEIGHT.V ? i.inputMete : null);
        }), (U = p.list) == null || U.forEach((i) => {
          var E, m, r, w, D, L;
          i.recipientId = i.recipientId || ((E = i.recipient) == null ? void 0 : E.userId), i.originQuantity = (m = i.materialInventoryDTO) == null ? void 0 : m.quantity, i.originMete = (r = i.materialInventoryDTO) == null ? void 0 : r.mete, i.isEdit = false, i.outboundId = p.id, i.projectId = i.projectId || ((w = i.project) == null ? void 0 : w.id), i.workshopId = i.workshopId || ((D = i.workshop) == null ? void 0 : D.id), i.materialId = (L = i.materialInventoryDTO) == null ? void 0 : L.id;
        }), R(p)) {
          const i = await qe(T.value[p.outboundTypeSelection]);
          e.push(i);
        }
      }), await Promise.all(e), R(T.value[n.value]) ? d.value = T.value[n.value] : d.value = {};
    } catch (e) {
      d.value = {}, console.log("加载失败", e);
    } finally {
      q.value = (/* @__PURE__ */ new Date()).getTime(), A.value = false;
    }
  }
  function je(e) {
    R(T.value[n.value]) ? d.value = T.value[n.value] : d.value = {};
  }
  async function qe(e) {
    return await Tt(e.list), e.list = await se(e.list, { toSmallest: false, toNum: false }, { unitNetCalcMete: "inputMete", quantity: ["quantity", "frozenQuantity", "originQuantity"], mete: ["mete", "inputMete", "theoryTotalWeight", "weighingWeight", "originMete", "actualTheoryWeight"], amount: ["unitPrice", "sellUnitPrice"] }), e.list.forEach((a) => {
      a.recipientCancel = a.recipientId, a.quantityCancel = a.quantity, a.meteCancel = a.mete, a.actualTheoryWeightCancel = a.actualTheoryWeight, a.projectIdCancel = a.projectId, a.workshopIdCancel = a.workshopId;
    }), e;
  }
  function Le(e) {
    e.recipientId = e.recipientCancel, e.quantity = e.quantityCancel, e.mete = e.meteCancel, e.actualTheoryWeight = e.actualTheoryWeightCancel, e.projectId = e.projectIdCancel, e.workshopId = e.workshopIdCancel, e.isEdit = false;
  }
  async function Be(e, a) {
    try {
      y.value = true, await Oe.value({ listId: d.value.id, materialId: e.id }), d.value.list.splice(a, 1), await M(), ++j.value;
    } catch (p) {
      console.log("删除", p);
    } finally {
      y.value = false;
    }
  }
  async function ze() {
    try {
      _e(d.value.list);
      const { validResult: e, dealList: a } = be(d.value.list);
      if (e) d.value.list = a;
      else return e;
      d.value.boolPartyA = false, y.value = true;
      const p = d.value.list.map((i) => i.basicClass);
      if ([...new Set(p)].length > 1) {
        ne.error("多种材料类型的物料无法同时出库");
        return;
      }
      await Ue.value(d.value), await M(), ++j.value, await de.dispatch("approval_list/fetchApprovalNum");
    } catch (e) {
      console.log("通过提交", e);
    } finally {
      y.value = false;
    }
  }
  async function $e() {
    try {
      y.value = true, await we.value(d.value.id), await M(), ++j.value;
    } catch (e) {
      console.log("退回", e);
    } finally {
      y.value = false;
    }
  }
  function Fe(e) {
    return Wt(e, { props: ["quantity", ["mete", Z.weight.precision], ["theoryTotalWeight", Z.weight.precision], ["weighingWeight", Z.weight.precision], "sellAmount"] });
  }
  function He() {
    d.value.list.forEach((e) => {
      e.outboundTime = q.value;
    });
  }
  return (e, a) => {
    const p = N("common-radio-button"), U = Ze, i = et, E = N("print-table"), m = tt, r = N("common-input-number"), w = at, D = N("common-table"), L = lt, Qe = it, Ye = N("common-drawer");
    return c(), f(Ye, { ref_key: "drawerRef", ref: Ee, modelValue: l(X), "onUpdate:modelValue": a[4] || (a[4] = (t) => Ke(X) ? X.value = t : null), "before-close": l(Pe), "show-close": true, "custom-class": "raw-mat-application-review-form", size: "100%", title: "出库清单" }, Je({ titleAfter: o(() => [u(p, { modelValue: n.value, "onUpdate:modelValue": a[0] || (a[0] = (t) => n.value = t), options: l(Y), size: "default", type: "enum", onChange: je }, { suffix: o(({ item: t }) => {
      var h, V, le, ie;
      return [(V = (h = T.value[t.V]) == null ? void 0 : h.list) != null && V.length ? (c(), O("span", jt, "(" + b((ie = (le = T.value[t.V]) == null ? void 0 : le.list) == null ? void 0 : ie.length) + ")", 1)) : g("", true)];
    }), _: 1 }, 8, ["modelValue", "options"])]), content: o(() => [u(Qe, { disabled: Ie.value, class: "form" }, { default: o(() => [u(D, { "cell-class-name": l(Te), data: d.value.list, "data-format": Re.value, "expand-row-keys": W.value, loading: A.value, "max-height": l(Se), "summary-method": Fe, "row-key": "id", "show-summary": "" }, { default: o(() => [u(Et, { "expand-row-keys": W.value, "onUpdate:expandRowKeys": a[2] || (a[2] = (t) => W.value = t), data: d.value.list, fixed: "left", "row-key": "id" }, { default: o(({ row: t }) => [u(Vt, { "basic-class": t.basicClass, row: t, "show-graphics": "", "show-remark": "" }, { default: o(() => [t.boolTransfer ? (c(), O("p", Lt, [a[8] || (a[8] = k(" 调拨： ")), a[9] || (a[9] = v("span", null, "（来源）", -1)), v("span", Bt, b(t.sourceProject), 1), a[10] || (a[10] = v("span", null, " ▶ ", -1)), a[11] || (a[11] = v("span", null, "（目的）", -1)), v("span", zt, b(t.project), 1)])) : g("", true)]), _: 2 }, 1032, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"]), u(Ct, { "basic-class": d.value.basicClass, "show-outbound-mode": "", showClassification: "" }, null, 8, ["basic-class"]), u(Ot), u(m, { key: "measureUnit", align: "center", label: "计量单位", prop: "measureUnit", "show-overflow-tooltip": "", width: "70px" }), u(m, { key: "quantity", label: "数量", prop: "quantity", align: "right", "show-overflow-tooltip": "", "min-width": "95px" }, { default: o(({ row: { sourceRow: t } }) => [t.outboundUnitType === l(z).MEASURE.V && l(_).quantity && n.value === l(s).PRODUCE.V && t.isEdit ? (c(), f(r, { key: 0, modelValue: t.quantity, "onUpdate:modelValue": (h) => t.quantity = h, min: 0, max: t.originQuantity, precision: t.measurePrecision, controls: false, "controls-position": "right", onChange: (h) => Me(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])) : g("", true)]), _: 1 }), u(m, { key: "accountingUnit", align: "center", label: "核算单位", prop: "accountingUnit", "show-overflow-tooltip": "", width: "70px" }), u(m, { key: "mete", label: "核算量", prop: "mete", align: "right", "show-overflow-tooltip": "", "min-width": "100px" }, { default: o(({ row: { sourceRow: t } }) => [t.outboundUnitType === l(z).ACCOUNTING.V && l(_).quantity && n.value === l(s).PRODUCE.V && t.isEdit ? (c(), f(r, { key: 0, modelValue: t.mete, "onUpdate:modelValue": (h) => t.mete = h, min: 0, max: t.originMete, precision: t.accountingPrecision, controls: false, "controls-position": "right", onChange: (h) => Ne(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])) : g("", true)]), _: 1 }), n.value === l(s).PRODUCE.V ? (c(), f(m, { key: 0, align: "center", label: "理论重量", prop: "actualTheoryWeight", width: "100px" })) : g("", true), n.value !== l(s).FOR_SALE.V ? (c(), f(m, { key: "projectId", align: "left", label: "项目", "min-width": "140px", prop: "projectId", "show-overflow-tooltip": "" }, { default: o(({ row: { sourceRow: t } }) => [l(_).project && n.value === l(s).PRODUCE.V && t.isEdit ? (c(), f(l(Ut), { key: 0, modelValue: t.projectId, "onUpdate:modelValue": (h) => t.projectId = h, style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (c(), O("span", $t, b(l(R)(t.project) ? l(wt)(t.project) : "-"), 1))]), _: 1 })) : g("", true), n.value === l(s).PRODUCE.V || n.value === l(s).TEMPORARY_LOAN.V || n.value === l(s).CONSTRUCTION_SITE_USE.V ? (c(), f(m, { key: "workshopId", label: n.value === l(s).PRODUCE.V || n.value === l(s).CONSTRUCTION_SITE_USE.V ? "领用车间" : "借用车间", "show-overflow-tooltip": true, align: "left", "min-width": "130", prop: "workshopId" }, { default: o(({ row: { sourceRow: t } }) => {
      var h;
      return [l(_).mesWorkshop && n.value === l(s).PRODUCE.V && t.isEdit ? (c(), f(l(It), { key: 0, modelValue: t.workshopId, "onUpdate:modelValue": (V) => t.workshopId = V, "factory-id": t.factoryId, clearable: "", placeholder: "可选择车间", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "factory-id"])) : (c(), O("span", Ft, b(((h = t.mesWorkshop) == null ? void 0 : h.name) || "-"), 1))];
    }), _: 1 }, 8, ["label"])) : g("", true), u(m, { key: "warehouse", align: "left", label: "仓库", "min-width": "130px", prop: "warehouse" }, { default: o(({ row: { sourceRow: t } }) => [v("div", Ht, [u(Rt, { id: t.workshop ? t.workshop.id : t.workshopId }, null, 8, ["id"]), u(w, { class: "item", effect: "dark", content: Ce(t), placement: "top-start" }, { default: o(() => [v("span", null, b(t.warehouse ? t.warehouse.name : t.warehouseName), 1)]), _: 2 }, 1032, ["content"])])]), _: 1 }), n.value === l(s).OUTSOURCE.V ? (c(), f(m, { key: "purchase.serialNumber", align: "center", label: "所属采购合同", prop: "purchase.serialNumber", width: "145px" })) : g("", true), n.value === l(s).OUTSOURCE.V || n.value === l(s).PRODUCE.V || n.value === l(s).TEMPORARY_LOAN.V ? (c(), f(m, { key: "recipientId", prop: "recipientId", label: n.value === l(s).TEMPORARY_LOAN.V ? "借用人" : "领用人", align: "center", "min-width": "140px" }, { default: o(({ row: { sourceRow: t } }) => [l(_).recipient && n.value === l(s).PRODUCE.V && t.isEdit ? (c(), f(St, { key: 0, modelValue: t.recipientId, "onUpdate:modelValue": (h) => t.recipientId = h, "collapse-tags": false, clearable: "", filterable: "", placeholder: "领用人", "show-all-levels": "", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (c(), O(x, { key: 1 }, [t.recipient ? (c(), f(w, { key: 0, content: `${t.recipient.deptName}`, effect: "light", placement: "top" }, { default: o(() => {
      var h;
      return [v("span", null, b(((h = t.recipient) == null ? void 0 : h.name) || "-"), 1)];
    }), _: 2 }, 1032, ["content"])) : g("", true)], 64))]), _: 1 }, 8, ["label"])) : g("", true), n.value === l(s).TEMPORARY_LOAN.V ? (c(), f(m, { key: "recipient", label: n.value === l(s).TEMPORARY_LOAN.V ? "借用人" : "领用人", align: "center", width: "100px" }, { default: o(({ row: t }) => [t.recipient ? (c(), f(w, { key: 0, content: `${t.recipient.deptName}`, effect: "light", placement: "top" }, { default: o(() => {
      var h;
      return [v("span", null, b(((h = t.recipient) == null ? void 0 : h.name) || "-"), 1)];
    }), _: 2 }, 1032, ["content"])) : g("", true)]), _: 1 }, 8, ["label"])) : g("", true), n.value === l(s).FOR_SALE.V ? (c(), O(x, { key: 6 }, [u(m, { align: "center", label: "理论重量", prop: "theoryTotalWeight", width: "100px" }, { default: o(({ row: t }) => [v("span", null, b(t.theoryTotalWeight || "-"), 1)]), _: 1 }), u(m, { align: "center", label: "过磅重量", prop: "weighingWeight", width: "100px" }, { default: o(({ row: t }) => [v("span", null, b(t.weighingWeight || "-"), 1)]), _: 1 }), u(m, { align: "center", label: "计量方式", width: "100px" }, { default: o(({ row: t }) => [v("span", null, b(l(J).VL[t.weightMeasurementMode] || "-"), 1)]), _: 1 }), u(m, { align: "center", label: "出售含税单价", width: "120px" }, { default: o(({ row: t }) => [v("span", null, b(t.sellUnitPrice || "-"), 1)]), _: 1 }), u(m, { align: "center", label: "出售含税金额", prop: "sellAmount", width: "120px" }, { default: o(({ row: t }) => [v("span", null, b(t.sellAmount || "-"), 1)]), _: 1 }), u(m, { align: "center", label: "出售票型及税率", width: "150px" }, { default: o(({ row: t }) => [v("span", null, b(`${l(Pt).VL[t.invoiceType]}(${t.taxRate}%)` || "-"), 1)]), _: 1 }), u(m, { align: "center", label: "购买方", prop: "purchaser", width: "120px" }, { default: o(({ row: t }) => [v("span", null, b(t.purchaser || "-"), 1)]), _: 1 })], 64)) : g("", true), u(m, { "show-overflow-tooltip": "", align: "center", label: "批次", prop: "areaBatchName", width: "100px" }), u(m, { align: "center", label: "出库时间", prop: "outboundTime", width: "195px" }, { default: o(({ row: { sourceRow: t }, $index: h }) => [d.value.reviewStatus === l(B).UNREVIEWED.V || n.value !== l(s).PRODUCE.V ? (c(), f(U, { key: 0, modelValue: t.outboundTime, "onUpdate:modelValue": (V) => t.outboundTime = V, placeholder: h === 0 ? "出库时间" : "同上", disabledDate: ee, type: "datetime", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue", "placeholder"])) : (c(), O("span", Qt, b(l(Dt)(t.outboundTime)), 1))]), _: 1 }), l(K)(l(G).outbound) && (n.value === l(s).PRODUCE.V && d.value.reviewStatus === l(B).UNREVIEWED.V || n.value !== l(s).PRODUCE.V) ? (c(), f(m, { key: 7, align: "left", fixed: "right", label: "操作", width: n.value === l(s).PRODUCE.V && ae.value ? "180px" : "70px" }, { default: o(({ row: { sourceRow: t }, $index: h }) => [n.value === l(s).PRODUCE.V && ae.value ? (c(), O(x, { key: 0 }, [t.isEdit ? (c(), O(x, { key: 1 }, [u(S, { loading: y.value, size: "default", type: "warning", onClick: (V) => Le(t) }, { default: o(() => a[12] || (a[12] = [k("取消")])), _: 2, __: [12] }, 1032, ["loading", "onClick"]), u(S, { loading: y.value, size: "default", type: "success", onClick: (V) => We(t) }, { default: o(() => a[13] || (a[13] = [k("保存")])), _: 2, __: [13] }, 1032, ["loading", "onClick"])], 64)) : (c(), f(S, { key: 0, loading: y.value, icon: "el-icon-edit", size: "default", type: "warning", onClick: (V) => xe(t) }, null, 8, ["loading", "onClick"]))], 64)) : g("", true), t.isEdit ? g("", true) : (c(), f(i, { key: 1, title: `确认删除当前${t.classifyFullName}吗?`, "cancel-button-text": "取消", "confirm-button-text": "确定", icon: "el-icon-info", "icon-color": "red", onConfirm: (V) => Be(t, h) }, { reference: o(() => [u(S, { disabled: !!(t.basicClass & l(P).STEEL_COIL.V && t.length), loading: y.value, icon: "el-icon-delete", size: "default", type: "danger" }, null, 8, ["disabled", "loading"])]), _: 2 }, 1032, ["title", "onConfirm"]))]), _: 1 }, 8, ["width"])) : g("", true)]), _: 1 }, 8, ["cell-class-name", "data", "data-format", "expand-row-keys", "loading", "max-height"]), u(L, { modelValue: d.value.remark, "onUpdate:modelValue": a[3] || (a[3] = (t) => d.value.remark = t), rows: 2, class: "approval-comments", maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { "margin-top": "5px" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 }, 8, ["disabled"])]), _: 2 }, [l(K)(l(G).outbound) ? { name: "titleRight", fn: o(() => [d.value.reviewStatus === l(B).UNREVIEWED.V && l(R)(d.value.list) || n.value !== l(s).PRODUCE.V && l(R)(d.value.list) ? (c(), O(x, { key: 0 }, [v("span", qt, [u(U, { modelValue: q.value, "onUpdate:modelValue": a[1] || (a[1] = (t) => q.value = t), placeholder: "批量设置出库时间", disabledDate: ee, type: "datetime", "value-format": "x" }, null, 8, ["modelValue"]), u(S, { size: "default", type: "success", onClick: He }, { default: o(() => a[5] || (a[5] = [k("设置")])), _: 1, __: [5] })]), l(K)(l(G).outboundAudit) ? (c(), f(i, { key: 0, "cancel-button-text": "取消", "confirm-button-text": "确定", icon: "el-icon-info", "icon-color": "green", title: "确认通过？", onConfirm: ze }, { reference: o(() => [u(S, { loading: y.value, icon: "el-icon-promotion", size: "default", type: "primary", disabled: te.value }, { default: o(() => a[6] || (a[6] = [k(" 提 交 ")])), _: 1, __: [6] }, 8, ["loading", "disabled"])]), _: 1 })) : g("", true), u(i, { "cancel-button-text": "取消", "confirm-button-text": "确定", icon: "el-icon-info", "icon-color": "red", title: "确认清空？", onConfirm: $e }, { reference: o(() => [u(S, { loading: y.value, icon: "el-icon-document-delete", size: "default", type: "danger", disabled: te.value }, { default: o(() => a[7] || (a[7] = [k(" 清 空 ")])), _: 1, __: [7] }, 8, ["loading", "disabled"])]), _: 1 })], 64)) : g("", true), d.value.reviewStatus === l(B).PASS.V ? (c(), f(E, { key: 1, params: d.value.id, "api-key": "wmsRmOutboundReceipt", class: "filter-item", size: "default", type: "warning" }, null, 8, ["params"])) : g("", true)]), key: "0" } : void 0]), 1032, ["modelValue", "before-close"]);
  };
} }, Jt = nt(Yt, [["__scopeId", "data-v-8bd2d273"]]);
export {
  Jt as default
};
