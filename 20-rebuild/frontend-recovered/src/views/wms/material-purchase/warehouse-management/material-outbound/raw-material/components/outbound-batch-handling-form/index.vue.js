import { computed as P } from "vue";
import { ref as V } from "vue";
import { watch as G } from "vue";
import { nextTick as tt } from "vue";
import { resolveComponent as j } from "vue";
import { resolveDirective as me } from "vue";
import { openBlock as b } from "vue";
import { createBlock as v } from "vue";
import { withCtx as r } from "vue";
import { unref as i } from "vue";
import { createTextVNode as N } from "vue";
import { createCommentVNode as f } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as y } from "vue";
import { withDirectives as K } from "vue";
import { createElementBlock as E } from "vue";
import { Fragment as M } from "vue";
import be from "moment";
import { toDisplayString as Q } from "vue";
import { isRef as at } from "vue";
import { ElMessage as he } from "element-plus";
import { ElFormItem as lt } from "element-plus";
import { ElInput as ot } from "element-plus";
import { ElDatePicker as nt } from "element-plus";
import { ElTableColumn as ut } from "element-plus";
import { ElTag as it } from "element-plus";
import { ElForm as st } from "element-plus";
import { cV as J, gG as u, j_ as _, bR as S, jY as rt, sP as dt, u as ct, o as pt, pB as X, i as x, a$ as mt, cP as U, b as ye, qS as ge, bD as Z, zL as fe, sQ as bt, cS as k, fv as ht, fD as yt, bG as gt, cy as ft, Ag as Tt, jJ as Vt, aR as vt, k4 as Et, jG as Ot, sO as St, k5 as Ut, k6 as Ct, aV as Rt, aw as _t, am as ee, sT as It, sU as xt, y2 as wt, iX as te, D as Te, jl as Pt, Ah as jt, yL as Ve, yJ as Mt, yK as kt, yM as At, yN as Lt, yO as Wt, Ai as Nt, Aj as Bt, Ak as Dt } from "../../../../../../../../shared/runtime.js";
const Qt = { class: "form-header" }, Ft = { key: 0 }, qt = { key: 1 }, Ht = { class: "flex-rbc" }, zt = { style: { flex: "none", "margin-left": "10px", "text-align": "left" } }, $t = { style: { display: "inline-block", width: "50px" } }, Yt = { style: { display: "flex", "justify-content": "center" } }, Gt = { key: 0 }, Kt = { key: 1 }, ea = { __name: "index", props: { visible: { type: Boolean, require: true }, projectWarehouseType: { type: Number }, projectId: { type: Number }, basicClass: { type: Number }, materialList: { type: Array, default: () => [] } }, emits: ["success", "update:visible"], setup(I, { emit: ve }) {
  const ae = ve, h = I, Ee = { projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }] }, Oe = { purchaseId: [{ required: true, message: "请选择采购合同", trigger: "change" }] }, Se = { workshopId: [{ validator: (t, a) => !(e.value.outboundTypeSelection === u.PRODUCE.V && !t), message: "请选择出库车间", trigger: "change" }] };
  let F = { sellUnitPrice: [{ required: true, message: "请输入出售含税单价", trigger: "blur" }], sellAmount: [{ required: true, message: "请输入出售含税金额", trigger: "blur" }] };
  const Ue = { inputMete: [{ required: true, message: "请输入过磅重量", trigger: "blur" }] }, Ce = P(() => {
    let t = {};
    return (h.basicClass & J && e.value.outboundTypeSelection === u.PRODUCE.V || e.value.outboundTypeSelection === u.OUTSOURCE.V) && (t = Object.assign(t, Se)), e.value.outboundTypeSelection === u.FOR_SALE.V && (h.basicClass & _.STEEL.V && e.value.weightMeasurementMode === S.OVERWEIGHT.V && (F = Object.assign(F, Ue)), t = Object.assign(t, F)), t;
  }), le = /* @__PURE__ */ new Map([["workshopId", -1]]), { tableValidate: Re, cleanUpData: _e, wrongCellMask: Ie } = _t({ rules: Ce, ditto: le }), xe = (t, a, d) => {
    e.value.invoiceType || e.value.invoiceType === 0 ? e.value.invoiceType === Z.SPECIAL.V && !e.value.taxRate ? d(new Error("请选择税率")) : d() : d(new Error("请选择发票及税率")), d();
  }, { outboundCfg: q, selfOutboundTypeOptions: we } = rt(), Pe = P(() => {
    let t = { outboundAddress: [{ required: true, message: "请选择出库目的地", trigger: "change" }], weightMeasurementMode: [{ required: true, message: "请选择关联交易单位", trigger: "change" }], invoiceType: [{ required: true, validator: xe, trigger: "change" }], isNeedRemind: [{ required: true, message: "请选择出库成功是否提醒", trigger: "change" }] };
    return (h.basicClass & J && e.value.outboundTypeSelection === u.PRODUCE.V || e.value.outboundTypeSelection === u.OUTSOURCE.V || h.basicClass & J && e.value.outboundTypeSelection === u.CONSTRUCTION_SITE_USE.V) && (t = Object.assign(t, Ee)), e.value.outboundTypeSelection === u.OUTSOURCE.V && (t = Object.assign(t, Oe)), q.value.productionOutBoundUserIsRequired && (t = Object.assign(t, { recipientId: [{ required: true, message: "请选领用人", trigger: "change" }] })), t;
  }), w = V(), H = V([]), oe = V([]), B = V([]), z = V([]), e = V({ list: [], recipientId: void 0 }), D = V(false), je = V([...dt, ["projectOperableQuantity", ["to-fixed-field", "measurePrecision"]], ["projectOperableMete", ["to-fixed-field", "accountingPrecision"]]]), { visible: A, handleClose: ne } = ct({ emit: ae, props: h, field: "visible", showHook: Be }), { maxHeight: Me } = pt({ mainBox: ".wms-batch-outbound-handling", extraBox: [".el-dialog__header", ".form-header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false, minHeight: 350 }, A), L = P(() => h.projectWarehouseType === X.PUBLIC.V), ue = P(() => e.value.outboundTypeSelection === u.PRODUCE.V && (L.value || q.value.boolCanOutToOtherProject === true) || e.value.outboundTypeSelection === u.OUTSOURCE.V || e.value.outboundTypeSelection === u.CONSTRUCTION_SITE_USE.V && (L.value || q.value.boolCanOutToOtherProject === true)), ke = P(() => {
    const t = {};
    return e.value.list.forEach((a) => {
      x(a.project) && !t[a.project.id] && (t[a.project.id] = a.project);
    }), mt(t);
  }), Ae = P(() => h.basicClass === U.STEEL_PLATE.V ? { minRows: 2, maxRows: 2 } : { minRows: 1, maxRows: 1 }), Le = V([S.THEORY, S.OVERWEIGHT]);
  G([() => h.projectId, () => h.projectWarehouseType], ([t, a], [d]) => {
    a === X.PUBLIC.V && (e.value.projectId = void 0);
  }, { immediate: true });
  const We = G(A, (t) => {
    t && (e.value.recipientId = void 0, tt(() => {
      We();
    }));
  }, { immediate: true });
  G(() => h.materialList, () => {
    ie(), B.value = [], oe.value = h.materialList.filter((a) => a.corOperableQuantity > 0);
    const t = JSON.parse(JSON.stringify(oe.value));
    Ne(t), e.value.list = t, ze();
  }, { deep: true, immediate: true });
  function Ne(t) {
    if (!ye(t)) for (let a = 1; a < t.length; a++) {
      const d = t[a];
      le.forEach((g, c) => {
        ye(d[c]) && (d[c] = g);
      });
    }
  }
  function ie() {
    B.value = [], e.value = { list: [] }, w.value && w.value.resetFields(), e.value.recipientId = void 0, e.value.outboundAddress = ge.FACTORY.V, e.value.branchCompanyId = void 0, e.value.weightMeasurementMode = S.THEORY.V, e.value.invoiceType = Z.SPECIAL.V, e.value.taxRate = void 0, e.value.outboundTypeSelection = u.PRODUCE.V, e.value.isNeedRemind = fe.YES.V;
  }
  function Be() {
    w.value && w.value.clearValidate(), e.value.outboundAddress = ge.FACTORY.V, e.value.weightMeasurementMode = S.THEORY.V, e.value.invoiceType = Z.SPECIAL.V, e.value.taxRate = void 0, e.value.outboundTypeSelection = u.PRODUCE.V;
  }
  function De(t) {
    var a, d;
    t === u.FOR_SALE.V && ((d = (a = e.value) == null ? void 0 : a.list) == null || d.forEach((g) => {
      g.sellUnitPrice = g.unitPrice;
    }));
  }
  const { baseUnit: W } = bt(h.basicClass);
  async function $(t) {
    var a;
    t.basicClass === ee.STEEL_PLATE.V ? t.theoryWeight = await It({ classifyId: t.classifyId, name: t.classifyFullName, length: t.length, width: t.width, thickness: t.thickness }) : t.basicClass === ee.SECTION_STEEL.V ? t.theoryWeight = await xt({ length: t.length, unitWeight: t.unitWeight }) : t.basicClass === ee.STEEL_COIL.V ? t.theoryWeight = await wt({ classifyId: t.classifyId, name: t.name, length: 1, width: t.width, thickness: t.thickness }) : t.theoryWeight = t.unitNet, x(t.theoryWeight) ? (t.theoryTotalWeight = te(t.theoryWeight * t.batchOutboundQuantity, ((a = W.value) == null ? void 0 : a.weight.precision) || 0), e.value.outboundTypeSelection === u.PRODUCE.V && (t.actualTheoryWeight = t.theoryTotalWeight)) : (t.theoryTotalWeight = void 0, e.value.outboundTypeSelection === u.PRODUCE.V && (t.actualTheoryWeight = void 0)), Y(t);
  }
  function Qe(t) {
    const a = e.value.weightMeasurementMode === 1 ? t.theoryTotalWeight : t.weighingWeight;
    x(t.sellUnitPrice) && x(a) && (t.sellUnitPrice = te(t.sellAmount / a, Te.YUAN));
  }
  function Y(t) {
    const a = e.value.weightMeasurementMode === 1 ? t.theoryTotalWeight : t.weighingWeight;
    x(t.sellUnitPrice) && x(a) && (t.sellAmount = te(a * t.sellUnitPrice, Te.YUAN));
  }
  function Fe() {
    e.value.list.forEach((t) => {
      t.batchOutboundQuantity = L.value ? t.corProjectOperableQuantity : t.corOperableQuantity, $(t);
    });
  }
  function qe() {
    e.value.list.forEach((t) => {
      t.batchOutboundQuantity = void 0, $(t);
    });
  }
  const se = V();
  async function re(t) {
    try {
      D.value = true;
      const a = await w.value.validate();
      if (se.value = t, !a) return;
      const d = e.value.list.filter((c) => c.batchOutboundQuantity);
      if (d.length === 0) {
        he.warning("请填写数据");
        return;
      }
      const { validResult: g } = Re(d);
      if (g) {
        _e(d);
        let c;
        e.value.outboundTypeSelection === u.PRODUCE.V || e.value.outboundTypeSelection === u.CONSTRUCTION_SITE_USE.V ? c = $e(h.basicClass) : c = Ye(e.value.outboundTypeSelection);
        let T = { boolSubmitCheck: t, outboundTypeSelection: e.value.outboundTypeSelection, outboundAddress: e.value.outboundAddress, isNeedRemind: e.value.isNeedRemind, boolPartyA: false, list: [] };
        if (e.value.outboundTypeSelection === u.PRODUCE.V || e.value.outboundTypeSelection === u.OUTSOURCE.V || e.value.outboundTypeSelection === u.CONSTRUCTION_SITE_USE.V) {
          const l = { projectId: e.value.projectId, areaBatchId: e.value.areaBatchId, recipientId: e.value.recipientId, outboundAddress: e.value.outboundAddress };
          T = Object.assign(T, l);
        }
        if (e.value.outboundTypeSelection === u.OUTSOURCE.V) {
          const l = { purchaseId: e.value.purchaseId, outboundTime: e.value.outboundTime };
          T = Object.assign(T, l);
        }
        if (e.value.outboundTypeSelection === u.FOR_SALE.V) {
          const l = { weightMeasurementMode: e.value.weightMeasurementMode, branchCompanyId: e.value.branchCompanyId, taxRate: e.value.taxRate, invoiceType: e.value.invoiceType, outboundTime: e.value.outboundTime, purchaser: e.value.purchaser };
          T = Object.assign(T, l);
        }
        const C = [];
        e.value.list.forEach((l) => {
          if (l.batchOutboundQuantity) {
            let p = { ...l, measureUnit: l.measureUnit, measurePrecision: l.measurePrecision, accountingUnit: l.accountingUnit, accountingPrecision: l.accountingPrecision, outboundQuantity: l.outboundUnitType === k.MEASURE.V ? l.batchOutboundQuantity : l.measureUnit && l.mete ? l.batchOutboundQuantity / l.mete * l.quantity : void 0, outboundMete: l.outboundUnitType === k.MEASURE.V ? l.accountingUnit && l.quantity ? l.batchOutboundQuantity / l.quantity * l.mete : void 0 : l.batchOutboundQuantity };
            if (e.value.outboundTypeSelection === u.FOR_SALE.V) {
              const R = { inputMete: e.value.weightMeasurementMode === S.THEORY.V ? l.theoryTotalWeight : l.weighingWeight, sellUnitPrice: l.sellUnitPrice, sellAmount: l.sellAmount, weightMeasurementMode: e.value.weightMeasurementMode };
              p = Object.assign(p, R);
            }
            C.push(p);
          }
        }), d.forEach((l, p) => {
          C[p].workshopId = l.workshopId;
        }), await Pt(C, { toNum: true, toSmallest: true }, { quantity: ["outboundQuantity"], mete: ["theoryTotalWeight", "weighingWeight", "outboundMete", "actualTheoryWeight"], amount: ["sellUnitPrice"] }), C.forEach((l) => {
          let p = { id: l.id, workshopId: l.workshopId, quantity: l.outboundUnitType === k.MEASURE.V ? l.outboundQuantity : l.outboundMete, outboundUnit: l.outboundUnit, outboundUnitPrecision: l.outboundUnitPrecision, outboundUnitType: l.outboundUnitType, measureUnit: l.measureUnit, measurePrecision: l.measurePrecision, accountingUnit: l.accountingUnit, accountingPrecision: l.accountingPrecision, projectId: e.value.projectId, areaBatchId: e.value.areaBatchId, remark: l.remark, realTime: l.realTime };
          if (e.value.outboundTypeSelection === u.FOR_SALE.V) {
            const R = { inputMete: e.value.weightMeasurementMode === S.THEORY.V ? l.theoryTotalWeight : l.weighingWeight, sellUnitPrice: l.sellUnitPrice, sellAmount: l.sellAmount, measureUnit: l.measureUnit, accountingUnit: l.accountingUnit, accountingPrecision: l.accountingPrecision, measurePrecision: l.measurePrecision, weightMeasurementMode: e.value.weightMeasurementMode };
            p = Object.assign(p, R);
          }
          l.basicClass === U.STEEL_PLATE.V && e.value.outboundTypeSelection === u.PRODUCE.V && (p.actualTheoryWeight = l.actualTheoryWeight), T.list.push(p);
        }), await c(T), he.success(`${t ? "已加入审核列表" : "已加入出库清单"}`), ae("success"), ne(), setTimeout(() => {
          ie();
        }, 0);
      } else return g;
    } catch (a) {
      console.log("出库办理", a);
    } finally {
      D.value = false;
    }
  }
  async function He(t) {
    if (z.value = [], e.value.areaBatchId = void 0, !e.value.projectId) return;
    const a = await jt({ projectId: e.value.projectId });
    z.value = a || [];
  }
  function ze() {
    h.projectWarehouseType === X.PUBLIC.V ? e.value.list.forEach((t) => {
      var d;
      if (t.factoryId = (d = t.factory) == null ? void 0 : d.id, !e.value.projectId || !t.projectFrozenKV || !t.projectFrozenKV[e.value.projectId]) t.projectOperableQuantity = t.operableQuantity, t.projectOperableMete = t.operableMete, t.corProjectOperableQuantity = t.corOperableQuantity;
      else {
        const g = t.projectFrozenKV[e.value.projectId];
        t.projectOperableQuantity = t.operableQuantity + (g.quantity || 0), t.projectOperableMete = t.operableMete + (g.mete || 0);
      }
      t.corProjectOperableQuantity = t.outboundUnitType === k.MEASURE.V ? t.projectOperableQuantity : t.projectOperableMete;
    }) : e.value.list.forEach((t) => {
      var a;
      t.factoryId = (a = t.factory) == null ? void 0 : a.id, t.corProjectOperableQuantity = t.outboundUnitType === k.MEASURE.V ? t.operableQuantity : t.operableMete;
    });
  }
  function $e(t) {
    switch (t) {
      case U.STEEL_PLATE.V:
      case U.OTHER_STEEL_MATERIALS.V:
        return Wt;
      case U.SECTION_STEEL.V:
        return Lt;
      case U.STEEL_COIL.V:
        return At;
      case U.MATERIAL.V:
        return Ve;
      case U.OTHER.V:
        return kt;
      case U.GAS.V:
        return Mt;
      default:
        return Ve;
    }
  }
  function Ye(t) {
    switch (t) {
      case u.OUTSOURCE.V:
        return Dt;
      case u.FOR_SALE.V:
        return se.value ? Nt : Bt;
      default:
        return null;
    }
  }
  return (t, a) => {
    const d = j("common-button"), g = j("common-radio"), c = lt, T = j("common-select-v2"), C = ot, l = nt, p = ut, R = j("common-input-number"), Ge = it, Ke = j("common-table"), Je = st, Xe = j("common-dialog"), Ze = me("parse-project"), de = me("to-fixed");
    return b(), v(Xe, { modelValue: i(A), "onUpdate:modelValue": a[16] || (a[16] = (s) => at(A) ? A.value = s : null), "before-close": i(ne), "show-close": true, "custom-class": "wms-batch-outbound-handling", title: "出库办理", top: "10vh", width: "95%" }, { titleRight: r(() => [e.value.outboundTypeSelection && e.value.outboundTypeSelection !== i(u).PRODUCE.V && e.value.outboundTypeSelection !== i(u).CONSTRUCTION_SITE_USE.V ? (b(), v(d, { key: 0, loading: D.value, size: "default", type: "primary", onClick: a[0] || (a[0] = (s) => re(true)) }, { default: r(() => a[17] || (a[17] = [N(" 提交审核 ")])), _: 1, __: [17] }, 8, ["loading"])) : f("", true), n(d, { loading: D.value, size: "default", type: "success", onClick: a[1] || (a[1] = (s) => re(false)) }, { default: r(() => a[18] || (a[18] = [N(" 保存至出库清单 ")])), _: 1, __: [18] }, 8, ["loading"])]), default: r(() => [n(Je, { ref_key: "formRef", ref: w, model: e.value, rules: Pe.value, class: "form", inline: "", "label-position": "right", "label-width": "70px", size: "default" }, { default: r(() => [y("div", Qt, [n(c, { label: "出库类型", prop: "outboundTypeSelection" }, { default: r(() => [n(g, { modelValue: e.value.outboundTypeSelection, "onUpdate:modelValue": a[2] || (a[2] = (s) => e.value.outboundTypeSelection = s), options: i(we), size: "default", type: "enum", onChange: De }, null, 8, ["modelValue", "options"])]), _: 1 }), !ue.value && e.value.outboundTypeSelection !== i(u).FOR_SALE.V ? (b(), v(c, { key: 0, label: "包含项目", "label-width": "80px" }, { default: r(() => [K(y("span", null, null, 512), [[Ze, { project: ke.value }]])]), _: 1 })) : (b(), E(M, { key: 1 }, [ue.value ? (b(), E(M, { key: 0 }, [n(c, { label: "项目", "label-width": "55px", prop: "projectId" }, { default: r(() => [n(i(ht), { modelValue: e.value.projectId, "onUpdate:modelValue": a[3] || (a[3] = (s) => e.value.projectId = s), class: "input-underline", clearable: "", filterable: "", style: { width: "300px" }, onChange: He }, null, 8, ["modelValue"])]), _: 1 }), n(c, { label: "批次", prop: "areaBatchId" }, { default: r(() => [n(T, { modelValue: e.value.areaBatchId, "onUpdate:modelValue": a[4] || (a[4] = (s) => e.value.areaBatchId = s), dataStructure: { key: "id", label: "name", value: "id" }, disabled: !e.value.projectId, options: z.value, class: "input-underline", clearable: "", collapseTags: "", filterable: "", placeholder: "请选择批次", size: "default", style: { width: "200px" } }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), n(c, { label: "出库成功是否提醒", "label-width": "135px", prop: "isNeedRemind" }, { default: r(() => [n(g, { modelValue: e.value.isNeedRemind, "onUpdate:modelValue": a[5] || (a[5] = (s) => e.value.isNeedRemind = s), options: i(fe).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 })], 64)) : f("", true)], 64)), e.value.outboundTypeSelection === i(u).FOR_SALE.V ? (b(), E(M, { key: 2 }, [a[19] || (a[19] = y("br", null, null, -1)), n(c, { label: "关联交易单位", "label-width": "100px", prop: "branchCompanyId" }, { default: r(() => [n(yt, { modelValue: e.value.branchCompanyId, "onUpdate:modelValue": a[6] || (a[6] = (s) => e.value.branchCompanyId = s), disabled: !!e.value.boolUsed, placeholder: "请选择关联交易单位", style: { width: "100%" } }, null, 8, ["modelValue", "disabled"])]), _: 1 }), n(c, { label: "购买方", "label-width": "100px", prop: "purchaser" }, { default: r(() => [n(C, { modelValue: e.value.purchaser, "onUpdate:modelValue": a[7] || (a[7] = (s) => e.value.purchaser = s), modelModifiers: { trim: true }, maxlength: "100", placeholder: "请输入购买方" }, null, 8, ["modelValue"])]), _: 1 }), h.basicClass & i(_).STEEL.V ? (b(), v(c, { key: 0, label: "计量方式", "label-width": "110px", prop: "weightMeasurementMode" }, { default: r(() => [n(g, { modelValue: e.value.weightMeasurementMode, "onUpdate:modelValue": a[8] || (a[8] = (s) => e.value.weightMeasurementMode = s), options: Le.value, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 })) : f("", true), n(c, { label: "票型及税率", "label-width": "110px", prop: "invoiceType" }, { default: r(() => [n(gt, { invoiceType: e.value.invoiceType, "onUpdate:invoiceType": a[9] || (a[9] = (s) => e.value.invoiceType = s), taxRate: e.value.taxRate, "onUpdate:taxRate": a[10] || (a[10] = (s) => e.value.taxRate = s), classification: h.basicClass, class: "input-underline" }, null, 8, ["invoiceType", "taxRate", "classification"])]), _: 1 }), n(c, { label: "出库日期", prop: "outboundTime" }, { default: r(() => [n(l, { modelValue: e.value.outboundTime, "onUpdate:modelValue": a[11] || (a[11] = (s) => e.value.outboundTime = s), disabledDate: (s) => i(be)(s).valueOf() < i(be)().subtract(1, "days").valueOf(), placeholder: "请选择出库日期", size: "default", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue", "disabledDate"])]), _: 1 })], 64)) : f("", true), e.value.outboundTypeSelection === i(u).PRODUCE.V || e.value.outboundTypeSelection === i(u).OUTSOURCE.V || e.value.outboundTypeSelection === i(u).CONSTRUCTION_SITE_USE.V ? (b(), v(c, { key: 3, label: "领用人", prop: "recipientId" }, { default: r(() => [n(ft, { modelValue: e.value.recipientId, "onUpdate:modelValue": a[12] || (a[12] = (s) => e.value.recipientId = s), "collapse-tags": false, class: "input-underline", clearable: "", filterable: "", placeholder: "领用人", "show-all-levels": "", style: { width: "300px" } }, null, 8, ["modelValue"])]), _: 1 })) : f("", true), e.value.outboundTypeSelection === i(u).OUTSOURCE.V ? (b(), E(M, { key: 4 }, [n(c, { label: "所属采购合同", "label-width": "110px", prop: "purchaseId" }, { default: r(() => [n(Tt, { modelValue: e.value.purchaseId, "onUpdate:modelValue": a[13] || (a[13] = (s) => e.value.purchaseId = s), "basic-class": e.value.basicClass, purchaseType: i(Vt).MANUFACTURED.V, class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "purchaseType"])]), _: 1 }), n(c, { label: "出库时间", prop: "outboundTime" }, { default: r(() => [n(l, { modelValue: e.value.outboundTime, "onUpdate:modelValue": a[14] || (a[14] = (s) => e.value.outboundTime = s), class: "input-underline", placeholder: "出库时间", type: "datetime", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 })], 64)) : f("", true)]), n(Ke, { ref: "tableRef", "cell-class-name": i(Ie), data: e.value.list, "data-format": je.value, "default-expand-all": false, "expand-row-keys": H.value, "max-height": i(Me), "row-key": "id" }, { default: r(() => {
      var s, ce, pe;
      return [n(vt, { "expand-row-keys": H.value, "onUpdate:expandRowKeys": a[15] || (a[15] = (o) => H.value = o), data: e.value.list, "row-key": "id" }, { default: r(({ row: o }) => [n(Et, { "basic-class": o.basicClass, row: o, "show-graphics": "" }, { default: r(() => [y("p", null, [a[20] || (a[20] = N(" 项目：")), y("span", null, Q(o.projectFullName), 1)]), n(C, { modelValue: o.sourceRow.remark, "onUpdate:modelValue": (m) => o.sourceRow.remark = m, autosize: Ae.value, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { "max-width": "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue", "autosize"])]), _: 2 }, 1032, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"]), n(Ot, { "basic-class": I.basicClass }, null, 8, ["basic-class"]), n(St, { "basic-class": I.basicClass, "operable-mete-field": L.value ? "projectOperableMete" : "operableMete", "operable-quantity-field": L.value ? "projectOperableQuantity" : "operableQuantity" }, null, 8, ["basic-class", "operable-mete-field", "operable-quantity-field"]), n(Ut, { "basic-class": I.basicClass, "show-batch-no": false }, null, 8, ["basic-class"]), n(Ct), e.value.outboundTypeSelection === i(u).PRODUCE.V ? (b(), E(M, { key: 0 }, [h.basicClass & i(_).STEEL.V ? (b(), v(p, { key: 0, label: `理论重量(${(s = i(W)) == null ? void 0 : s.weight.unit})`, align: "center", prop: "actualTheoryWeight", width: "170px" }, { default: r(({ row: { sourceRow: o } }) => [o.basicClass === i(U).STEEL_PLATE.V ? (b(), E("span", Ft, Q(o.actualTheoryWeight || 0), 1)) : (b(), E("span", qt, "-"))]), _: 1 }, 8, ["label"])) : f("", true)], 64)) : f("", true), e.value.outboundTypeSelection === i(u).PRODUCE.V || e.value.outboundTypeSelection === i(u).CONSTRUCTION_SITE_USE.V ? (b(), v(p, { key: "workshopId", align: "center", label: "车间", prop: "workshopId", width: "170px" }, { default: r(({ row: { sourceRow: o }, $index: m }) => {
        var O;
        return [n(i(Rt), { modelValue: o.workshopId, "onUpdate:modelValue": (et) => o.workshopId = et, "factory-id": (O = o.factory) == null ? void 0 : O.id, "show-extra": m !== 0, clearable: "", placeholder: "可选择车间", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "factory-id", "show-extra"])];
      }), _: 1 })) : f("", true), n(p, { align: "center", label: "出库数量", width: "230px" }, { header: r(() => [a[21] || (a[21] = y("span", null, "出库数量", -1)), y("span", { class: "text-clickable", style: { "margin-left": "10px" }, onClick: Fe }, "全部出库"), y("span", { class: "text-clickable", style: { "margin-left": "10px" }, onClick: qe }, "清空")]), default: r(({ row: { sourceRow: o } }) => {
        var m;
        return [y("span", Ht, [n(R, { modelValue: o.batchOutboundQuantity, "onUpdate:modelValue": (O) => o.batchOutboundQuantity = O, max: o.corProjectOperableQuantity, min: 0, precision: o.outboundUnitPrecision, "controls-position": "right", onChange: (O) => $(o) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"]), y("span", zt, [y("span", $t, [(I.basicClass & i(_).STEEL.V || I.basicClass & i(_).MATERIAL.V || I.basicClass & i(_).OTHER.V) && B.value.findIndex((O) => O.id === o.id) > -1 && !(o.batchOutboundQuantity < ((m = B.value.find((O) => O.id === o.id)) == null ? void 0 : m.quantity)) ? (b(), v(Ge, { key: 0, class: "ml-2", style: { "margin-left": "2px" }, type: "danger" }, { default: r(() => a[22] || (a[22] = [N(" 不足 ")])), _: 1, __: [22] })) : f("", true)])])])];
      }), _: 1 }), e.value.outboundTypeSelection === i(u).FOR_SALE.V ? (b(), E(M, { key: 2 }, [n(p, { label: "系统核算量", align: "center", prop: "mete", width: "170px" }, { default: r(({ row: { sourceRow: o } }) => {
        var m;
        return [y("div", Yt, [i(x)(o.measureUnit) && o.outboundUnitType === i(k).MEASURE.V ? (b(), E("div", Gt, [K(y("span", null, null, 512), [[de, { val: o.batchOutboundQuantity / o.quantity * o.mete || 0, dp: o.accountingPrecision }]])])) : (b(), E("div", Kt, [K(y("span", null, null, 512), [[de, { val: o.batchOutboundQuantity || 0, dp: o.accountingPrecision }]])])), N(" " + Q(((m = i(W)) == null ? void 0 : m.weight.unit) || o.accountingUnit), 1)])];
      }), _: 1 }), e.value.weightMeasurementMode === i(S).THEORY.V && h.basicClass & i(_).STEEL.V ? (b(), v(p, { key: 0, label: `理论重量(${((ce = i(W)) == null ? void 0 : ce.weight.unit) || t.row.accountingUnit})`, align: "center", prop: "theoryTotalWeight", width: "170px" }, { default: r(({ row: { sourceRow: o } }) => [y("span", null, Q(o.theoryTotalWeight || 0), 1)]), _: 1 }, 8, ["label"])) : f("", true), e.value.weightMeasurementMode === i(S).OVERWEIGHT.V && h.basicClass & i(_).STEEL.V ? (b(), v(p, { key: 1, label: `过磅重量(${(pe = i(W)) == null ? void 0 : pe.weight.unit})`, align: "center", prop: "inputMete", width: "170px" }, { default: r(({ row: { sourceRow: o } }) => [n(R, { modelValue: o.weighingWeight, "onUpdate:modelValue": (m) => o.weighingWeight = m, controls: false, max: 999999999, min: 1e-6, placeholder: `过磅重量(${o.accountingUnit})`, step: 1, size: "default", style: { width: "100%" }, onChange: (m) => Y(o) }, null, 8, ["modelValue", "onUpdate:modelValue", "placeholder", "onChange"])]), _: 1 }, 8, ["label"])) : f("", true), n(p, { align: "center", label: "出售含税单价", prop: "sellUnitPrice", width: "170px" }, { default: r(({ row: { sourceRow: o } }) => [n(R, { modelValue: o.sellUnitPrice, "onUpdate:modelValue": (m) => o.sellUnitPrice = m, controls: false, max: 999999999, min: 1e-6, step: 1, placeholder: "出售含税单价", size: "default", style: { width: "100%" }, onChange: (m) => Y(o) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 }), n(p, { align: "center", label: "出售含税金额", prop: "sellAmount", width: "170px" }, { default: r(({ row: { sourceRow: o } }) => [n(R, { modelValue: o.sellAmount, "onUpdate:modelValue": (m) => o.sellAmount = m, controls: false, max: 999999999, min: 1e-6, step: 1, placeholder: "出售含税金额", size: "default", style: { width: "100%" }, onChange: (m) => Qe(o) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 }), n(p, { align: "center", label: "备注", prop: "remark", width: "170px" }, { default: r(({ row: { sourceRow: o } }) => [n(C, { modelValue: o.remark, "onUpdate:modelValue": (m) => o.remark = m, modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "备注", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })], 64)) : f("", true)];
    }), _: 1 }, 8, ["cell-class-name", "data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["model", "rules"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ea as default
};
