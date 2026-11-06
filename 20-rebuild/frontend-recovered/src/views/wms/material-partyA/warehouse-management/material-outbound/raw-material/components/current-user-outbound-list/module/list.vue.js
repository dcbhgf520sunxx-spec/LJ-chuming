import { ref as _ } from "vue";
import { computed as B } from "vue";
import { inject as Ne } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as d } from "vue";
import { createBlock as y } from "vue";
import { createSlots as Ae } from "vue";
import { unref as l } from "vue";
import { withCtx as s } from "vue";
import { createElementBlock as E } from "vue";
import { Fragment as z } from "vue";
import { createElementVNode as V } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as x } from "vue";
import { createCommentVNode as g } from "vue";
import { toDisplayString as w } from "vue";
import { isRef as Be } from "vue";
import { ElMessage as ne } from "element-plus";
import { ElDatePicker as ze } from "element-plus";
import { ElPopconfirm as Le } from "element-plus";
import { ElTableColumn as $e } from "element-plus";
import { ElTooltip as Fe } from "element-plus";
import { ElInput as He } from "element-plus";
import { ElForm as Qe } from "element-plus";
import { _ as Ge, yX as Xe, gG as C, jY as Je, jX as Ke, qS as Ye, o as Ze, u as et, zO as tt, i as k, cO as at, jl as oe, G as K, kD as O, xT as I, aR as it, k4 as lt, jG as nt, k5 as ot, cS as L, aV as st, cy as ut, p as rt, bl as U, aw as dt, yQ as ct, sT as se, sU as mt, iX as $, zP as pt, zQ as ft, zR as yt, zS as gt, ba as ht, jN as vt } from "../../../../../../../../../shared/runtime.js";
const bt = { key: 0 }, _t = { class: "batch-set-info child-mr-7" }, Ct = { key: 0 }, Tt = { style: { color: "brown" } }, Et = { style: { color: "#3a8ee6" } }, Vt = { key: 1 }, It = { key: 1 }, Ut = { __name: "list", props: { visible: { type: Boolean, default: false } }, emits: ["refresh", "update:visible"], setup(ue, { emit: re }) {
  const { lastTime: F } = Xe();
  function Y(e) {
    return k(F.value) && F.value.endTime ? e.getTime() < Number(F.value.endTime) + 1 * 1e3 || e.getTime() > (/* @__PURE__ */ new Date()).getTime() : e.getTime() > (/* @__PURE__ */ new Date()).getTime();
  }
  const H = re, de = ue, p = _(C.PRODUCE.V), ce = /* @__PURE__ */ new Map([["outboundTime", null]]), Z = B(() => {
    var e;
    return ((e = n.value.list) == null ? void 0 : e.findIndex((a) => a.isEdit)) > -1;
  }), { outboundCfg: Q, partyAOutboundTypeOptions: ee, produceOutboundEditConf: h } = Je(), me = (e, a) => {
    var r;
    return (r = Q.value) != null && r.productionOutBoundUserIsRequired && h.value.recipient && p.value === C.PRODUCE.V ? !!e : true;
  }, pe = (e, a) => h.value.mesWorkshop && p.value === C.PRODUCE.V ? !!e : true, fe = (e, a) => a.measureUnit && k(a.measurePrecision && a.outboundUnitType === L.MEASURE.V) ? !!e : true, ye = (e, a) => !!e, te = B(() => h.value.recipient || h.value.mesWorkshop || h.value.quantity || h.value.project), ge = { quantity: [{ validator: fe, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: ye, message: "核算量必须大于0", trigger: "blur" }], recipientId: [{ validator: me, message: "请选择领用人", trigger: "change" }], workshopId: [{ validator: pe, message: "请选择生产车间", trigger: "change" }], outboundTime: [{ required: true, message: "请选择出库时间", trigger: "change" }] }, { tableValidate: he, cleanUpData: xt, wrongCellMask: ve } = dt({ rules: ge, ditto: ce }), G = Ne("permission"), be = _(), c = _(false), S = _(false), D = _([]), n = _({}), W = _(0), q = _(), _e = B(() => c.value), Ce = _([...Ke, ["outboundAddress", ["parse-enum", Ye]], ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), { maxHeight: Te } = Ze({ mainBox: ".raw-mat-application-review-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => B(() => !S.value)), { visible: X, handleClose: Ee } = et({ emit: H, props: de, field: "visible", showHook: Ve, closeHook: Ie });
  function Ve() {
    J(), ae();
  }
  function Ie() {
    W.value && H("refresh");
  }
  function J() {
    S.value = false, c.value = false, c.value = false, D.value = [], n.value = {};
  }
  const v = _({});
  async function Ue(e) {
    e.materialOutboundMode === ct.HALF.V && (e.basicClass === U.STEEL_PLATE.V || e.basicClass === U.SECTION_STEEL.V) ? (e.basicClass === U.STEEL_PLATE.V && (e.theoryWeight = await se({ classifyId: e.classifyId, name: e.classifyFullName, length: e.length, width: e.width, thickness: e.thickness })), e.basicClass === U.SECTION_STEEL.V && (e.theoryWeight = await mt({ length: e.length, unitWeight: e.unitWeight })), e.theoryTotalWeight = $(e.theoryWeight * e.quantity, e.accountingPrecision || 0), e.basicClass === U.STEEL_PLATE.V && (e.actualTheoryWeight = e.theoryTotalWeight), e.mete = e.theoryTotalWeight) : (e.basicClass === U.STEEL_PLATE.V && (e.theoryWeight = await se({ classifyId: e.classifyId, name: e.classifyFullName, length: e.length, width: e.width, thickness: e.thickness }), e.theoryTotalWeight = $(e.theoryWeight * e.quantity, e.accountingPrecision || 0), e.actualTheoryWeight = e.theoryTotalWeight), e.mete = $(e.quantity / e.originQuantity * e.originMete, e.accountingPrecision));
  }
  function xe(e) {
    e.measureUnit && e.measurePrecision && (e.quantity = $(e.mete / e.originMete * e.originQuantity, e.measurePrecision));
  }
  function we(e) {
    e.isEdit = true;
  }
  async function ke(e) {
    var a, r;
    try {
      if (!e.recipientId && ((a = Q.value) != null && a.productionOutBoundUserIsRequired) || !e.workshopId || !e.mete || !e.outboundTime) {
        const u = (r = Q.value) != null && r.productionOutBoundUserIsRequired ? "核算量、领用车间、领用人、出库时间必填" : "核算量、领用车间、出库时间必填";
        ne.error(u);
        return;
      }
      c.value = true;
      const i = JSON.parse(JSON.stringify(e));
      await oe(i, { basicClass: i.basicClass, measureUnit: i.measureUnit, measurePrecision: i.measurePrecision, accountingUnit: i.accountingUnit, accountingPrecision: i.accountingPrecision, toNum: true, toSmallest: true }, { quantity: ["quantity"], mete: ["mete", "actualTheoryWeight"] });
      const T = { id: i.outboundId, deleteDetailIds: [i.id], list: [{ materialId: i.materialId, workshopId: i.workshopId, outboundUnit: i.outboundUnit, outboundUnitPrecision: i.outboundUnitPrecision, projectId: i.projectId, materialOutboundMode: i.materialOutboundMode, halfMode: i.halfMode, halfSize: i.halfSize, outboundTypeSelection: p.value, remark: i.remark, quantity: i.outboundUnitType === L.MEASURE.V ? i.quantity : i.mete, boolPartyA: true, outboundTime: i.outboundTime, recipientId: i.recipientId, actualTheoryWeight: i.actualTheoryWeight }] };
      await pt(T), await ae(), e.isEdit = false, H("refresh");
    } catch (i) {
      console.log("删除", i);
    } finally {
      c.value = false;
    }
  }
  async function ae() {
    try {
      S.value = true, v.value = {};
      const e = [], a = await tt({ boolPartyA: true });
      ee.value.forEach((r) => {
        v.value[r.V] = {};
      }), a.forEach(async (r) => {
        var i;
        if (v.value[r.outboundTypeSelection] = r, k(r)) {
          (i = r.list) == null || i.forEach((u) => {
            var f, P, j, M, N, A;
            u.recipientId = u.recipientId || ((f = u.recipient) == null ? void 0 : f.userId), u.originQuantity = (P = u.materialInventoryDTO) == null ? void 0 : P.quantity, u.originMete = (j = u.materialInventoryDTO) == null ? void 0 : j.mete, u.isEdit = false, u.outboundId = r.id, u.projectId = u.projectId || ((M = u.project) == null ? void 0 : M.id), u.workshopId = u.workshopId || ((N = u.workshop) == null ? void 0 : N.id), u.materialId = (A = u.materialInventoryDTO) == null ? void 0 : A.id;
          });
          const T = await Pe(v.value[r.outboundTypeSelection]);
          e.push(T);
        }
      }), await Promise.all(e), k(v.value[p.value]) ? n.value = v.value[p.value] : n.value = {};
    } catch (e) {
      n.value = {}, console.log("加载失败", e);
    } finally {
      q.value = (/* @__PURE__ */ new Date()).getTime(), S.value = false;
    }
  }
  function Se(e) {
    e.recipientId = e.recipientCancel, e.quantity = e.quantityCancel, e.mete = e.meteCancel, e.actualTheoryWeight = e.actualTheoryWeightCancel, e.projectId = e.projectIdCancel, e.workshopId = e.workshopIdCancel, e.isEdit = false;
  }
  async function Pe(e) {
    return await at(e.list), e.list = await oe(e.list, { toSmallest: false, toNum: false }, { unitNetCalcMete: "inputMete", quantity: ["quantity", "frozenQuantity", "originQuantity"], mete: ["mete", "inputMete", "theoryTotalWeight", "weighingWeight", "originMete", "actualTheoryWeight"], amount: ["unitPrice"] }), e.list.forEach((a) => {
      a.recipientCancel = a.recipientId, a.quantityCancel = a.quantity, a.meteCancel = a.mete, a.actualTheoryWeightCancel = a.actualTheoryWeight, a.projectIdCancel = a.projectId, a.workshopIdCancel = a.workshopId;
    }), e;
  }
  async function Re(e, a) {
    try {
      c.value = true, await ft({ listId: n.value.id, materialId: e.id }), n.value.list.splice(a, 1), ++W.value, n.value.list.length === 0 && J();
    } catch (r) {
      console.log("删除", r);
    } finally {
      c.value = false;
    }
  }
  async function Oe() {
    try {
      const { validResult: e, dealList: a } = he(n.value.list);
      if (e) n.value.list = a;
      else return e;
      n.value.boolPartyA = true, c.value = true;
      const r = n.value.list.map((T) => T.basicClass);
      if ([...new Set(r)].length > 1) {
        ne.error("多种材料类型的物料无法同时出库");
        return;
      }
      await yt(n.value), n.value.reviewStatus = O.PASS.V, ++W.value;
    } catch (e) {
      console.log("通过提交", e);
    } finally {
      c.value = false;
    }
  }
  async function De() {
    try {
      c.value = true, await gt(n.value.id), ++W.value, J();
    } catch (e) {
      console.log("退回", e);
    } finally {
      c.value = false;
    }
  }
  function We(e) {
    return ht(e, { props: ["quantity", ["mete", vt.weight.precision]] });
  }
  function qe() {
    n.value.list.forEach((e) => {
      e.outboundTime = q.value;
    });
  }
  function je(e) {
    k(v.value[p.value]) ? n.value = v.value[p.value] : n.value = {};
  }
  return (e, a) => {
    const r = R("common-radio-button"), i = ze, T = Le, u = R("print-table"), f = $e, P = R("common-input-number"), j = Fe, M = R("common-table"), N = He, A = Qe, Me = R("common-drawer");
    return d(), y(Me, { ref_key: "drawerRef", ref: be, modelValue: l(X), "onUpdate:modelValue": a[4] || (a[4] = (t) => Be(X) ? X.value = t : null), "before-close": l(Ee), "content-loading": S.value, "show-close": true, "custom-class": "raw-mat-application-review-form", size: "100%", title: "出库清单" }, Ae({ titleAfter: s(() => [o(r, { modelValue: p.value, "onUpdate:modelValue": a[0] || (a[0] = (t) => p.value = t), options: l(ee), size: "default", type: "enum", onChange: je }, { suffix: s(({ item: t }) => {
      var m, b, ie, le;
      return [(b = (m = v.value[t.V]) == null ? void 0 : m.list) != null && b.length ? (d(), E("span", bt, "(" + w((le = (ie = v.value[t.V]) == null ? void 0 : ie.list) == null ? void 0 : le.length) + ")", 1)) : g("", true)];
    }), _: 1 }, 8, ["modelValue", "options"])]), content: s(() => [o(A, { disabled: _e.value, class: "form" }, { default: s(() => [o(M, { data: n.value.list, "cell-class-name": l(ve), "data-format": Ce.value, "expand-row-keys": D.value, "max-height": l(Te), "summary-method": We, "row-key": "id", "show-summary": "" }, { default: s(() => [o(it, { "expand-row-keys": D.value, "onUpdate:expandRowKeys": a[2] || (a[2] = (t) => D.value = t), data: n.value.list, fixed: "left", "row-key": "id" }, { default: s(({ row: t }) => [o(lt, { "basic-class": t.basicClass, row: t, "show-graphics": "", "show-remark": "" }, { default: s(() => [t.boolTransfer ? (d(), E("p", Ct, [a[8] || (a[8] = x(" 调拨： ")), a[9] || (a[9] = V("span", null, "（来源）", -1)), V("span", Tt, w(t.sourceProject), 1), a[10] || (a[10] = V("span", null, " ▶ ", -1)), a[11] || (a[11] = V("span", null, "（目的）", -1)), V("span", Et, w(t.project), 1)])) : g("", true)]), _: 2 }, 1032, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"]), o(nt, { "basic-class": n.value.basicClass, "show-outbound-mode": "", showClassification: "" }, null, 8, ["basic-class"]), o(ot), o(f, { key: "measureUnit", align: "center", label: "计量单位", prop: "measureUnit", "show-overflow-tooltip": "", width: "70px" }), o(f, { key: "quantity", label: "数量", prop: "quantity", align: "right", "show-overflow-tooltip": "", "min-width": "95px" }, { default: s(({ row: { sourceRow: t } }) => [t.outboundUnitType === l(L).MEASURE.V && l(h).quantity && p.value === l(C).PRODUCE.V && t.isEdit ? (d(), y(P, { key: 0, modelValue: t.quantity, "onUpdate:modelValue": (m) => t.quantity = m, min: 0, max: t.originQuantity, precision: t.measurePrecision, controls: false, "controls-position": "right", onChange: (m) => Ue(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])) : g("", true)]), _: 1 }), o(f, { key: "accountingUnit", align: "center", label: "核算单位", prop: "accountingUnit", "show-overflow-tooltip": "", width: "70px" }), o(f, { key: "mete", label: "核算量", prop: "mete", align: "right", "show-overflow-tooltip": "", "min-width": "100px" }, { default: s(({ row: { sourceRow: t } }) => [t.outboundUnitType === l(L).ACCOUNTING.V && l(h).quantity && p.value === l(C).PRODUCE.V && t.isEdit ? (d(), y(P, { key: 0, modelValue: t.mete, "onUpdate:modelValue": (m) => t.mete = m, min: 0, max: t.originMete, precision: t.accountingPrecision, controls: false, "controls-position": "right", onChange: (m) => xe(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])) : g("", true)]), _: 1 }), o(f, { align: "center", label: "理论重量", prop: "actualTheoryWeight", width: "100px" }), o(f, { key: "project", align: "left", label: "项目", "min-width": "140px", prop: "project", "show-overflow-tooltip": "" }), o(f, { key: "workshopId", label: "领用车间", "show-overflow-tooltip": true, align: "left", "min-width": "130", prop: "workshopId" }, { default: s(({ row: { sourceRow: t } }) => {
      var m;
      return [l(h).mesWorkshop && p.value === l(C).PRODUCE.V && t.isEdit ? (d(), y(l(st), { key: 0, modelValue: t.workshopId, "onUpdate:modelValue": (b) => t.workshopId = b, "factory-id": t.factoryId, clearable: "", placeholder: "可选择车间", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "factory-id"])) : (d(), E("span", Vt, w(((m = t.mesWorkshop) == null ? void 0 : m.name) || "-"), 1))];
    }), _: 1 }), o(f, { align: "center", label: "出库目的地", prop: "outboundAddress", width: "100px" }), o(f, { align: "center", key: "recipientId", prop: "recipientId", label: "领用人", width: "100px" }, { default: s(({ row: { sourceRow: t } }) => [l(h).recipient && p.value === l(C).PRODUCE.V && t.isEdit ? (d(), y(ut, { key: 0, modelValue: t.recipientId, "onUpdate:modelValue": (m) => t.recipientId = m, "collapse-tags": false, clearable: "", filterable: "", placeholder: "领用人", "show-all-levels": "", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (d(), E(z, { key: 1 }, [t.recipient ? (d(), y(j, { key: 0, content: `${t.recipient.deptName}`, effect: "light", placement: "top" }, { default: s(() => [V("span", null, w(t.recipient.name), 1)]), _: 2 }, 1032, ["content"])) : g("", true)], 64))]), _: 1 }), o(f, { "show-overflow-tooltip": "", align: "center", label: "批次", prop: "areaBatchName", width: "100px" }), o(f, { align: "center", label: "出库时间", prop: "outboundTime", width: "195px" }, { default: s(({ row: { sourceRow: t }, $index: m }) => [n.value.reviewStatus === l(O).UNREVIEWED.V || p.value !== l(C).PRODUCE.V ? (d(), y(i, { key: 0, modelValue: t.outboundTime, "onUpdate:modelValue": (b) => t.outboundTime = b, disabledDate: Y, placeholder: m === 0 ? "出库时间" : "同上", type: "datetime", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue", "placeholder"])) : (d(), E("span", It, w(l(rt)(t.outboundTime)), 1))]), _: 1 }), l(K)(l(G).outbound) && n.value.reviewStatus === l(O).UNREVIEWED.V ? (d(), y(f, { key: 0, align: "left", fixed: "right", label: "操作", width: p.value === l(C).PRODUCE.V && te.value ? "180px" : "70px" }, { default: s(({ row: { sourceRow: t }, $index: m }) => [p.value === l(C).PRODUCE.V && te.value ? (d(), E(z, { key: 0 }, [t.isEdit ? (d(), E(z, { key: 1 }, [o(I, { loading: c.value, size: "default", type: "warning", onClick: (b) => Se(t) }, { default: s(() => a[12] || (a[12] = [x("取消")])), _: 2, __: [12] }, 1032, ["loading", "onClick"]), o(I, { loading: c.value, size: "default", type: "success", onClick: (b) => ke(t) }, { default: s(() => a[13] || (a[13] = [x("保存")])), _: 2, __: [13] }, 1032, ["loading", "onClick"])], 64)) : (d(), y(I, { key: 0, loading: c.value, icon: "el-icon-edit", size: "default", type: "warning", onClick: (b) => we(t) }, null, 8, ["loading", "onClick"]))], 64)) : g("", true), t.isEdit ? g("", true) : (d(), y(T, { key: 1, title: `确认删除当前${t.classifyFullName}吗?`, "cancel-button-text": "取消", "confirm-button-text": "确定", icon: "el-icon-info", "icon-color": "red", onConfirm: (b) => Re(t, m) }, { reference: s(() => [o(I, { disabled: !!(t.basicClass & l(U).STEEL_COIL.V && t.length), loading: c.value, icon: "el-icon-delete", size: "default", type: "danger" }, null, 8, ["disabled", "loading"])]), _: 2 }, 1032, ["title", "onConfirm"]))]), _: 1 }, 8, ["width"])) : g("", true)]), _: 1 }, 8, ["data", "cell-class-name", "data-format", "expand-row-keys", "max-height"]), o(N, { modelValue: n.value.remark, "onUpdate:modelValue": a[3] || (a[3] = (t) => n.value.remark = t), rows: 2, class: "approval-comments", maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { "margin-top": "5px" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 }, 8, ["disabled"])]), _: 2 }, [l(K)(l(G).outbound) ? { name: "titleRight", fn: s(() => [n.value.reviewStatus === l(O).UNREVIEWED.V && l(k)(n.value.list) ? (d(), E(z, { key: 0 }, [V("span", _t, [o(i, { modelValue: q.value, "onUpdate:modelValue": a[1] || (a[1] = (t) => q.value = t), placeholder: "批量设置出库时间", type: "datetime", disabledDate: Y, "value-format": "x" }, null, 8, ["modelValue"]), o(I, { size: "default", type: "success", onClick: qe }, { default: s(() => a[5] || (a[5] = [x("设置")])), _: 1, __: [5] })]), l(K)(l(G).outboundAudit) ? (d(), y(T, { key: 0, "cancel-button-text": "取消", "confirm-button-text": "确定", icon: "el-icon-info", "icon-color": "green", title: "确认通过？", onConfirm: Oe }, { reference: s(() => [o(I, { loading: c.value, icon: "el-icon-promotion", size: "default", type: "primary", disabled: Z.value }, { default: s(() => a[6] || (a[6] = [x(" 提交 ")])), _: 1, __: [6] }, 8, ["loading", "disabled"])]), _: 1 })) : g("", true), o(T, { "cancel-button-text": "取消", "confirm-button-text": "确定", icon: "el-icon-info", "icon-color": "red", title: "确认清空？", onConfirm: De }, { reference: s(() => [o(I, { loading: c.value, icon: "el-icon-document-delete", size: "default", type: "danger", disabled: Z.value }, { default: s(() => a[7] || (a[7] = [x(" 清 空 ")])), _: 1, __: [7] }, 8, ["loading", "disabled"])]), _: 1 })], 64)) : g("", true), n.value.reviewStatus === l(O).PASS.V ? (d(), y(u, { key: 1, params: n.value.id, "api-key": "wmsRmOutboundReceipt", class: "filter-item", size: "default", type: "warning" }, null, 8, ["params"])) : g("", true)]), key: "0" } : void 0]), 1032, ["modelValue", "before-close", "content-loading"]);
  };
} }, St = Ge(Ut, [["__scopeId", "data-v-b3da0271"]]);
export {
  St as default
};
