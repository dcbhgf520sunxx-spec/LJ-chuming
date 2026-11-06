import { ref as g } from "vue";
import { computed as x } from "vue";
import { watch as N } from "vue";
import { nextTick as Ce } from "vue";
import { resolveComponent as E } from "vue";
import { resolveDirective as Re } from "vue";
import { openBlock as I } from "vue";
import { createBlock as O } from "vue";
import { withCtx as s } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as C } from "vue";
import { createElementVNode as h } from "vue";
import { unref as c } from "vue";
import { withDirectives as Be } from "vue";
import { createElementBlock as W } from "vue";
import { Fragment as Se } from "vue";
import { createCommentVNode as q } from "vue";
import { toDisplayString as z } from "vue";
import { isRef as ve } from "vue";
import { ElMessage as ee } from "element-plus";
import { ElFormItem as Qe } from "element-plus";
import { ElInput as Ae } from "element-plus";
import { ElTableColumn as Le } from "element-plus";
import { ElTag as Me } from "element-plus";
import { ElForm as Ne } from "element-plus";
import { fg as We, sQ as qe, jY as ze, sP as Fe, u as He, o as De, pB as F, a$ as $e, cP as y, gG as Ke, zL as H, b as te, qS as D, i as U, zM as Ye, z as Ge, cS as P, cy as Je, aR as Xe, k4 as Ze, jG as et, sO as tt, k5 as at, k6 as ot, aV as lt, j_ as R, aw as nt, sT as it, iX as st, jl as ut, yL as ae, yJ as rt, yK as ct, yM as dt, yN as pt, yO as mt } from "../../../../../../../../shared/runtime.js";
const bt = { class: "form-header" }, ft = { class: "flex-rbc" }, ht = { style: { flex: "none", "margin-left": "10px", "text-align": "left" } }, yt = { style: { display: "inline-block", width: "50px" } }, gt = { key: 0 }, jt = { key: 1 }, _t = { __name: "index", props: { visible: { type: Boolean, require: true }, projectWarehouseType: { type: Number }, projectId: { type: Number }, basicClass: { type: Number }, materialList: { type: Array, default: () => [] } }, emits: ["success", "update:visible"], setup(V, { emit: oe }) {
  const $ = oe, f = V;
  We();
  const { baseUnit: K } = qe(f.basicClass), B = g(false), le = { projectId: [{ required: true, message: "选择项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择出库车间", trigger: "change" }] }, Y = /* @__PURE__ */ new Map([["workshopId", -1], ["areaBatchId", -1]]), { tableValidate: ne, cleanUpData: G, wrongCellMask: ie } = nt({ rules: le, errorMsg: "请选择出库车间", ditto: Y }), { outboundCfg: J, partyAOutboundTypeOptions: se } = ze(), ue = x(() => {
    let e = { outboundAddress: [{ required: true, message: "请选择出库目的地", trigger: "change" }], isNeedRemind: [{ required: true, message: "请选择出库成功是否提醒", trigger: "change" }] };
    return J.value.productionOutBoundUserIsRequired && (e = Object.assign(e, { recipientId: [{ required: true, message: "请选领用人", trigger: "change" }] })), e;
  }), _ = g(), S = g([]), v = g([]), k = g([]), Q = g({}), o = g({ list: [], recipientId: void 0 }), A = g(false), re = g([...Fe, ["projectOperableQuantity", ["to-fixed-field", "measurePrecision"]], ["projectOperableMete", ["to-fixed-field", "accountingPrecision"]]]), { visible: T, handleClose: X } = He({ emit: $, props: f, field: "visible", showHook: he }), { maxHeight: ce } = De({ mainBox: ".wms-batch-outbound-handling", extraBox: [".el-dialog__header", ".form-header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false, minHeight: 350 }, T), w = x(() => f.projectWarehouseType === F.PUBLIC.V), Z = x(() => w.value || J.value.boolCanOutToOtherProject === true), de = x(() => {
    const e = {};
    return o.value.list.forEach((t) => {
      e[t.project.id] || (e[t.project.id] = t.project);
    }), $e(e);
  }), pe = x(() => f.basicClass === y.STEEL_PLATE.V ? { minRows: 2, maxRows: 2 } : { minRows: 1, maxRows: 1 });
  N([() => f.projectId, () => f.projectWarehouseType], ([e, t], [n]) => {
    t === F.PUBLIC.V && (o.value.projectId = void 0);
  }, { immediate: true });
  const me = N(T, (e) => {
    e && (o.value.recipientId = void 0, Ce(() => {
      me();
    }));
  }, { immediate: true });
  N(() => f.materialList, async () => {
    o.value.projectId = void 0, k.value = [], v.value = f.materialList.filter((t) => t.corOperableQuantity > 0), v.value.forEach((t) => {
      var n;
      t.originProjectId = t.projectId || ((n = t.project) == null ? void 0 : n.id);
    });
    const e = JSON.parse(JSON.stringify(v.value));
    await Ie(e), be(e), o.value.list = e, o.value.outboundTypeSelection = Ke.PRODUCE.V, o.value.isNeedRemind = H.YES.V, Ee();
  });
  function be(e) {
    if (!te(e)) for (let t = 1; t < e.length; t++) {
      const n = e[t];
      Y.forEach((u, r) => {
        te(n[r]) && (n[r] = u);
      });
    }
  }
  function fe() {
    k.value = [], o.value = { list: [] }, _.value && _.value.resetFields(), o.value.recipientId = void 0, o.value.outboundAddress = D.FACTORY.V, o.value.isNeedRemind = H.YES.V;
  }
  function he() {
    _.value && _.value.clearValidate(), o.value.outboundAddress = D.FACTORY.V;
  }
  function ye() {
    o.value.list.forEach((e) => {
      e.batchOutboundQuantity = w.value ? e.corProjectOperableQuantity : e.corOperableQuantity, L(e);
    });
  }
  function ge() {
    o.value.list.forEach((e) => {
      e.batchOutboundQuantity = void 0, L(e);
    });
  }
  async function L(e) {
    var t;
    e.basicClass === y.STEEL_PLATE.V && (e.theoryWeight = await it({ classifyId: e.classifyId, name: e.classifyFullName, length: e.length, width: e.width, thickness: e.thickness })), U(e.theoryWeight) ? (e.theoryTotalWeight = st(e.theoryWeight * e.batchOutboundQuantity, ((t = K.value) == null ? void 0 : t.weight.precision) || 0), e.actualTheoryWeight = e.theoryTotalWeight) : (e.theoryTotalWeight = void 0, e.actualTheoryWeight = void 0);
  }
  async function je() {
    try {
      if (A.value = true, !await _.value.validate()) return;
      const t = o.value.list.filter((u) => u.batchOutboundQuantity);
      if (t.length === 0) {
        ee.warning("请填写数据");
        return;
      }
      const { validResult: n } = ne(t);
      if (n) {
        G(t);
        const u = Te(f.basicClass), r = { projectId: o.value.projectId, areaBatchId: o.value.areaBatchId, isNeedRemind: o.value.isNeedRemind, recipientId: o.value.recipientId, boolPartyA: true, outboundAddress: o.value.outboundAddress, outboundTypeSelection: o.value.outboundTypeSelection, list: [] };
        G(o.value.list);
        const j = [];
        o.value.list.forEach((a) => {
          a.batchOutboundQuantity && j.push({ ...a, measureUnit: a.measureUnit, measurePrecision: a.measurePrecision, accountingUnit: a.accountingUnit, accountingPrecision: a.accountingPrecision, outboundQuantity: a.outboundUnitType === P.MEASURE.V ? a.batchOutboundQuantity : a.measureUnit && a.mete ? a.batchOutboundQuantity / a.mete * a.quantity : void 0, outboundMete: a.outboundUnitType === P.MEASURE.V ? a.accountingUnit && a.quantity ? a.batchOutboundQuantity / a.quantity * a.mete : void 0 : a.batchOutboundQuantity, remark: a.remark, realTime: a.realTime });
        }), t.forEach((a, p) => {
          j[p].workshopId = a.workshopId, j[p].projectId = a.projectId, j[p].areaBatchId = a.areaBatchId;
        }), await ut(j, { toNum: true, toSmallest: true }, { quantity: ["outboundQuantity"], mete: ["theoryTotalWeight", "outboundMete", "actualTheoryWeight"] }), j.forEach((a) => {
          const p = { id: a.id, workshopId: a.workshopId, quantity: a.outboundUnitType === P.MEASURE.V ? a.outboundQuantity : a.outboundMete, outboundUnit: a.outboundUnit, outboundUnitPrecision: a.outboundUnitPrecision, outboundUnitType: a.outboundUnitType, measureUnit: a.measureUnit, measurePrecision: a.measurePrecision, accountingUnit: a.accountingUnit, accountingPrecision: a.accountingPrecision, projectId: a.projectId, areaBatchId: a.areaBatchId, remark: a.remark };
          a.basicClass === y.STEEL_PLATE.V && (p.actualTheoryWeight = a.actualTheoryWeight), r.list.push(p);
        }), await u(r), ee.success("已加入出库清单"), $("success"), X(), setTimeout(() => {
          fe();
        }, 0);
      } else return n;
    } catch (e) {
      console.log("出库办理", e);
    } finally {
      A.value = false;
    }
  }
  async function Ie(e) {
    if (!U(e)) return;
    const t = [];
    e.forEach((n) => {
      t.includes(n.originProjectId) || t.push(n.originProjectId);
    });
    try {
      B.value = true;
      const n = await Ye(t);
      for (const u in n) U(n[u]) && n[u].forEach((r) => {
        r.fullName = Ge(r);
      });
      Q.value = n || {};
    } catch (n) {
      console.log(n);
    } finally {
      e.forEach((n) => {
        n.projectId = n.originProjectId;
      }), B.value = false;
    }
  }
  function Ve(e) {
    return e ? Q.value[e] || [] : [];
  }
  function _e(e) {
    var t;
    return e.projectId ? ((t = (Q.value[e.originProjectId] || []).find((r) => r.id === e.projectId)) == null ? void 0 : t.areaBatchList) || [] : [];
  }
  function Ee() {
    f.projectWarehouseType === F.PUBLIC.V ? o.value.list.forEach((e) => {
      var n;
      if (e.factoryId = (n = e.factory) == null ? void 0 : n.id, !o.value.projectId || !e.projectFrozenKV || !e.projectFrozenKV[o.value.projectId]) e.projectOperableQuantity = e.operableQuantity, e.projectOperableMete = e.operableMete, e.corProjectOperableQuantity = e.corOperableQuantity;
      else {
        const u = e.projectFrozenKV[o.value.projectId];
        e.projectOperableQuantity = e.operableQuantity + (u.quantity || 0), e.projectOperableMete = e.operableMete + (u.mete || 0);
      }
      e.corProjectOperableQuantity = e.outboundUnitType === P.MEASURE.V ? e.projectOperableQuantity : e.projectOperableMete;
    }) : o.value.list.forEach((e) => {
      var t;
      e.factoryId = (t = e.factory) == null ? void 0 : t.id, e.corProjectOperableQuantity = e.outboundUnitType === P.MEASURE.V ? e.operableQuantity : e.operableMete;
    });
  }
  function Te(e) {
    switch (e) {
      case y.STEEL_PLATE.V:
      case y.OTHER_STEEL_MATERIALS.V:
        return mt;
      case y.SECTION_STEEL.V:
        return pt;
      case y.STEEL_COIL.V:
        return dt;
      case y.MATERIAL.V:
        return ae;
      case y.OTHER.V:
        return ct;
      case y.GAS.V:
        return rt;
      default:
        return ae;
    }
  }
  return (e, t) => {
    const n = E("common-button"), u = E("common-radio"), r = Qe, j = Ae, a = E("common-select-v2"), p = Le, xe = E("common-input-number"), Oe = Me, Ue = E("common-table"), Pe = Ne, ke = E("common-dialog"), we = Re("parse-project");
    return I(), O(ke, { modelValue: c(T), "onUpdate:modelValue": t[5] || (t[5] = (m) => ve(T) ? T.value = m : null), "before-close": c(X), "show-close": true, "custom-class": "wms-batch-outbound-handling", title: "出库办理", top: "10vh", width: "100%" }, { titleRight: s(() => [i(n, { loading: A.value, size: "default", type: "primary", onClick: je }, { default: s(() => t[6] || (t[6] = [C(" 提 交")])), _: 1, __: [6] }, 8, ["loading"])]), default: s(() => [i(Pe, { ref_key: "formRef", ref: _, model: o.value, rules: ue.value, class: "form", inline: "", "label-position": "right", "label-width": "70px", size: "default" }, { default: s(() => [h("div", bt, [i(r, { label: "出库类型", prop: "outboundTypeSelection" }, { default: s(() => [i(u, { modelValue: o.value.outboundTypeSelection, "onUpdate:modelValue": t[0] || (t[0] = (m) => o.value.outboundTypeSelection = m), options: c(se), size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), Z.value ? (I(), W(Se, { key: 1 }, [Z.value ? (I(), O(r, { key: 0, label: "出库成功是否提醒", "label-width": "140px", prop: "isNeedRemind" }, { default: s(() => [i(u, { modelValue: o.value.isNeedRemind, "onUpdate:modelValue": t[1] || (t[1] = (m) => o.value.isNeedRemind = m), options: c(H).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 })) : q("", true)], 64)) : (I(), O(r, { key: 0, label: "包含项目", "label-width": "80px" }, { default: s(() => [Be(h("span", null, null, 512), [[we, { project: de.value }]])]), _: 1 })), i(r, { label: "出库目的地", "label-width": "95px", prop: "outboundAddress" }, { default: s(() => [i(u, { modelValue: o.value.outboundAddress, "onUpdate:modelValue": t[2] || (t[2] = (m) => o.value.outboundAddress = m), options: c(D).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), i(r, { label: "领用人", prop: "recipientId" }, { default: s(() => [i(Je, { modelValue: o.value.recipientId, "onUpdate:modelValue": t[3] || (t[3] = (m) => o.value.recipientId = m), "collapse-tags": false, class: "input-underline", clearable: "", filterable: "", placeholder: "领用人", "show-all-levels": "", style: { width: "300px" } }, null, 8, ["modelValue"])]), _: 1 })]), i(Ue, { ref: "tableRef", "cell-class-name": c(ie), data: o.value.list, "data-format": re.value, "default-expand-all": false, "expand-row-keys": S.value, "max-height": c(ce), loading: B.value, "row-key": "id" }, { default: s(() => {
      var m;
      return [i(Xe, { "expand-row-keys": S.value, "onUpdate:expandRowKeys": t[4] || (t[4] = (l) => S.value = l), data: o.value.list, fixed: "left", "row-key": "id" }, { default: s(({ row: l }) => [i(Ze, { "basic-class": l.basicClass, row: l, "show-graphics": "" }, { default: s(() => [h("p", null, [t[7] || (t[7] = C(" 项目：")), h("span", null, z(l.projectFullName), 1)]), i(j, { modelValue: l.sourceRow.remark, "onUpdate:modelValue": (d) => l.sourceRow.remark = d, autosize: pe.value, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { "max-width": "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue", "autosize"])]), _: 2 }, 1032, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"]), i(et, { "basic-class": V.basicClass, fixed: "left" }, null, 8, ["basic-class"]), i(tt, { "basic-class": V.basicClass, "operable-mete-field": w.value ? "projectOperableMete" : "operableMete", "operable-quantity-field": w.value ? "projectOperableQuantity" : "operableQuantity" }, null, 8, ["basic-class", "operable-mete-field", "operable-quantity-field"]), i(at, { "basic-class": V.basicClass, "show-batch-no": false }, null, 8, ["basic-class"]), i(ot), i(p, { align: "center", fixed: "right", label: "项目", prop: "projectId", width: "170px" }, { default: s(({ row: { sourceRow: l } }) => [i(a, { modelValue: l.projectId, "onUpdate:modelValue": (d) => l.projectId = d, dataStructure: { key: "id", label: "fullName", value: "id" }, options: Ve(l.originProjectId), class: "filter-item", clearable: "", collapseTags: "", filterable: "", placeholder: "请选择项目", size: "default", style: { width: "100%" }, onChange: (d) => l.areaBatchId = void 0 }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 1 }), i(p, { align: "center", fixed: "right", label: "批次", prop: "areaBatchId", width: "170px" }, { default: s(({ row: { sourceRow: l }, $index: d }) => {
        var b;
        return [i(a, { modelValue: l.areaBatchId, "onUpdate:modelValue": (M) => l.areaBatchId = M, dataStructure: { key: "id", label: "name", value: "id" }, disabled: !l.projectId, options: _e(l), "show-extra": d !== 0 && l.projectId && c(U)(o.value.list) && c(U)(o.value.list[d - 1]) && l.projectId === ((b = o.value.list[d - 1]) == null ? void 0 : b.projectId), clearable: "", collapseTags: "", filterable: "", placeholder: "请选择批次", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "options", "show-extra"])];
      }), _: 1 }), i(p, { align: "center", fixed: "right", label: "车间", prop: "workshopId", width: "170px" }, { default: s(({ row: { sourceRow: l }, $index: d }) => {
        var b;
        return [i(c(lt), { modelValue: l.workshopId, "onUpdate:modelValue": (M) => l.workshopId = M, "factory-id": (b = l.factory) == null ? void 0 : b.id, "show-extra": d !== 0, clearable: "", placeholder: "可选择车间", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "factory-id", "show-extra"])];
      }), _: 1 }), i(p, { align: "center", fixed: "right", label: "出库数量", width: "230px" }, { header: s(() => [t[8] || (t[8] = h("span", null, "出库数量", -1)), h("span", { class: "text-clickable", style: { "margin-left": "10px" }, onClick: ye }, "全部出库"), h("span", { class: "text-clickable", style: { "margin-left": "10px" }, onClick: ge }, "清空")]), default: s(({ row: { sourceRow: l } }) => {
        var d;
        return [h("span", ft, [i(xe, { modelValue: l.batchOutboundQuantity, "onUpdate:modelValue": (b) => l.batchOutboundQuantity = b, max: l.corProjectOperableQuantity, min: 0, precision: l.outboundUnitPrecision, "controls-position": "right", onChange: (b) => L(l) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"]), h("span", ht, [C(z(l.outboundUnit), 1), h("span", yt, [(V.basicClass & c(R).STEEL.V || V.basicClass & c(R).MATERIAL.V || V.basicClass & c(R).OTHER.V) && k.value.findIndex((b) => b.id === l.id) > -1 && !(l.batchOutboundQuantity < ((d = k.value.find((b) => b.id === l.id)) == null ? void 0 : d.quantity)) ? (I(), O(Oe, { key: 0, class: "ml-2", style: { "margin-left": "2px" }, type: "danger" }, { default: s(() => t[9] || (t[9] = [C("不足")])), _: 1, __: [9] })) : q("", true)])])])];
      }), _: 1 }), f.basicClass & c(R).STEEL.V ? (I(), O(p, { key: 0, label: `理论重量(${(m = c(K)) == null ? void 0 : m.weight.unit})`, align: "center", prop: "actualTheoryWeight", width: "170px" }, { default: s(({ row: { sourceRow: l } }) => [l.basicClass === c(y).STEEL_PLATE.V ? (I(), W("span", gt, z(l.actualTheoryWeight || 0), 1)) : (I(), W("span", jt, "-"))]), _: 1 }, 8, ["label"])) : q("", true)];
    }), _: 1 }, 8, ["cell-class-name", "data", "data-format", "expand-row-keys", "max-height", "loading"])]), _: 1 }, 8, ["model", "rules"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  _t as default
};
