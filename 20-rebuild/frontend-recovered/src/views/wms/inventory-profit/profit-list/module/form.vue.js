import { ref as L } from "vue";
import { provide as Le } from "vue";
import { computed as J } from "vue";
import { reactive as Te } from "vue";
import { watch as I } from "vue";
import { ElMessageBox as _e } from "element-plus";
import { nextTick as ye } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as x } from "vue";
import { createVNode as c } from "vue";
import { withCtx as d } from "vue";
import { createTextVNode as he } from "vue";
import { unref as t } from "vue";
import { Fragment as Q } from "vue";
import { renderList as Ee } from "vue";
import { createBlock as Y } from "vue";
import { createCommentVNode as k } from "vue";
import { withDirectives as X } from "vue";
import { createElementVNode as w } from "vue";
import { vShow as Z } from "vue";
import { resolveDynamicComponent as ge } from "vue";
import { toDisplayString as ee } from "vue";
import { ElMessage as te } from "element-plus";
import { ElFormItem as Se } from "element-plus";
import { ElCheckbox as be } from "element-plus";
import { ElCheckboxGroup as ve } from "element-plus";
import { ElCard as Ve } from "element-plus";
import { ElForm as xe } from "element-plus";
import { _ as Ce, o as Ie, jP as u, xL as ae, bD as A, ao as ke, i as E, cJ as s, bv as we, bG as Ae, b as R } from "../../../../../shared/runtime.js";
import Re from "./components/application/steel/index.vue.js";
import Me from "./components/application/other/index.vue.js";
import Pe from "./components/submit-preview.vue.js";
import "./components/application/steel/module/steel-plate-table.vue.js";
import "./components/application/price-set-columns.vue.js";
import "../../../../../modules/supplier-select-0ce6adf5.js";
import "./components/application/steel/module/section-steel-table.vue.js";
import "./components/application/steel/module/steel-coil-table.vue.js";
import "./components/application/other/module/other-steel-material-table.vue.js";
import "./components/application/other/module/other-table.vue.js";
import "./components/application/other/module/auxiliary-material-table.vue.js";
import "./components/application/other/module/gas-table.vue.js";
const Be = { key: 0 }, Ne = { key: 1 }, Oe = { __name: "form", emits: ["handleSuccess"], setup(Ue, { emit: le }) {
  const ie = le, M = L(), P = L(), g = L(), { maxHeight: oe } = Ie({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true, extraHeight: 140 }, M), se = { invoiceType: [{ required: true, validator: (i, a, n) => {
    e.invoiceType ? (e.invoiceType === A.SPECIAL.V || e.invoiceType === A.ORDINARY.V) && R(e.taxRate) ? n(new Error("请选择税率")) : n() : n(new Error("请选择"));
  }, trigger: "change" }], boolPartyA: [{ required: true, message: "请选择物料属性", trigger: "change" }], basicClass: [{ required: true, message: "请选择物料类型", trigger: "blur" }] }, B = [{ ...u.STEEL }, { ...u.MATERIAL }, { ...u.OTHER }, { ...u.GAS }], S = L({}), ne = { boolPartyA: ae.SELF.V, materialType: void 0, basicClass: void 0, invoiceType: A.SPECIAL.V, currentBasicClass: void 0, list: [], sectionSteelList: [], steelPlateList: [], steelCoilList: [], otherSteelMaterialList: [], auxiliaryMaterialList: [], otherList: [], gasList: [] }, { CRUD: N, crud: m, form: e } = ke(ne);
  Le("crud", m);
  const f = L([]), C = L(false), T = L([]), O = J(() => m.status.cu > N.STATUS.NORMAL), re = J(() => {
    if (E(e.materialType)) switch (e.materialType) {
      case u.STEEL.V:
        return Re;
      default:
        return Me;
    }
    else return null;
  }), b = Te({ steelPlateList: null, sectionSteelList: null, sectionCoilList: null, otherSteelMaterialList: null, auxList: null, gasList: null, otherList: null });
  function ue() {
    return Object.keys(b).every((i) => b[i] ? b[i].validate() : true);
  }
  function U() {
    E(f.value) ? e.basicClass = f.value.reduce((i, a) => i | a) : (e.materialType = void 0, e.basicClass = void 0);
  }
  function ce() {
    f.value = [];
  }
  async function de() {
    var n, r;
    if (await ((n = P.value) == null ? void 0 : n.validate()), !ue()) return;
    if (e.boolPartyA) {
      e.invoiceType = void 0, e.taxRate = void 0;
      for (const l in s) (r = e[s[l].LIST]) == null || r.forEach((p) => {
        p.supplierId = void 0, p.supplier = {}, p.unitPrice = void 0, p.amount = void 0;
      });
    }
    if (e.list = [...e.steelPlateList, ...e.sectionSteelList, ...e.steelCoilList, ...e.otherSteelMaterialList, ...e.auxiliaryMaterialList, ...e.gasList, ...e.otherList], !e.list.length) {
      te.error("请添加数据");
      return;
    }
    const i = e.list.map((l) => ({ classifyId: l.classifyId, specification: l.specification, thickness: l.thickness, quantity: l.quantity, length: l.length, totalLength: l.totalLength, theoryWeight: l.theoryWeight, theoryTotalWeight: l.theoryTotalWeight, heatNoAndBatchNo: l.heatNoAndBatchNo, brand: l.brand, projectId: l.projectId, workshopId: l.workshopId, warehouseId: l.warehouseId, supplierId: l.supplierId, materialIsWhole: l.materialIsWhole, mete: l.mete, color: l.color }));
    T.value = [];
    let a = false;
    for (let l = 0; l <= i.length - 1; l++) {
      a = false;
      let p = 0;
      for (let _ = 0; _ <= i.length - 1; _++) {
        let h = true;
        for (const v in i[_]) if (i[l][v] !== i[_][v]) {
          h = false;
          break;
        }
        h && p++;
      }
      p > 1 && (a = true), a && T.value.push(e.list[l].uid);
    }
    if (T.value = [...new Set(T.value)], E(T.value)) {
      te.error("存在相同内容的数据，请修改！");
      return;
    }
    C.value = true;
  }
  function pe(i) {
    m.cancelCU(), m.toQuery(), i || ie("handleSuccess");
  }
  return I(() => f.value, (i, a) => {
    if (i.length < a.length && O.value) {
      let n, r;
      _e.confirm("您确定取消该分类吗?", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }).then(() => {
        for (let l = 0; l < a.length; l++) i.includes(a[l]) || (n = a[l]);
        B.forEach((l) => {
          l.V === n && (r = l.V);
        }), r === u.STEEL.V ? (e.steelCoilList = [], e.sectionSteelList = [], e.steelPlateList = [], e.otherSteelMaterialList = []) : e[s.V[r].LIST] = [];
      }).catch(() => {
        f.value = a, U();
      }).finally(() => {
        var l;
        g.value && E(r) && ((l = g.value) == null || l.handleClearByBasicClass(r));
      });
    }
  }), I(() => e.basicClass, (i) => {
    if (S.value = {}, E(i)) {
      const a = we.getBits(u, i, "V");
      for (const n in u.ENUM) for (let r = 0; r < a.length; r++) u.ENUM[n].V === a[r] && (S.value[n] = u.ENUM[n]);
      e.materialType = a[0];
    } else e.materialType = void 0, S.value = {};
  }, { deep: true, immediate: true }), I(() => e.currentBasicClass, (i) => {
    if (i) {
      let a;
      switch (i) {
        case s.STEEL_PLATE.V:
          a = "steelPlateList";
          break;
        case s.SECTION_STEEL.V:
          a = "sectionSteelList";
          break;
        case s.STEEL_COIL.V:
          a = "sectionCoilList";
          break;
        case s.OTHER_STEEL_MATERIALS.V:
          a = "otherSteelMaterialList";
          break;
        case u.MATERIAL.V:
          a = "auxList";
          break;
        case u.GAS.V:
          a = "gasList";
          break;
        default:
          a = "otherList";
          break;
      }
      ye(() => {
        b[a] = g.value;
      });
    }
  }, { immediate: true }), N.HOOK.beforeToCU = () => {
    ce();
  }, (i, a) => {
    const n = V("common-button"), r = V("common-radio"), l = Se, p = be, _ = ve, h = Ve, v = V("common-radio-button"), me = xe, fe = V("common-drawer");
    return y(), x(Q, null, [c(fe, { ref_key: "drawerRef", ref: M, "before-close": t(m).cancelCU, "content-loading": t(m).editDetailLoading, "show-close": true, title: t(m).status.title, visible: O.value, "custom-class": "profit-application-record-form", size: "100%" }, { titleRight: d(() => [c(n, { size: "default", type: "primary", onClick: de }, { default: d(() => a[6] || (a[6] = [he(" 下一步 ")])), _: 1, __: [6] })]), content: d(() => [c(me, { ref_key: "formRef", ref: P, model: t(e), rules: se, class: "form", inline: "", "label-position": "right", "label-width": "70px", size: "default" }, { default: d(() => [c(h, null, { default: d(() => [c(l, { label: "物料属性：", "label-width": "100px", prop: "boolPartyA" }, { default: d(() => [c(r, { modelValue: t(e).boolPartyA, "onUpdate:modelValue": a[0] || (a[0] = (o) => t(e).boolPartyA = o), dataStructure: { key: "K", label: "SL", value: "V" }, options: t(ae).V, size: "default", type: "other" }, null, 8, ["modelValue", "options"])]), _: 1 }), c(l, { label: "物料类型：", "label-width": "100px", prop: "basicClass" }, { default: d(() => [c(_, { modelValue: f.value, "onUpdate:modelValue": a[1] || (a[1] = (o) => f.value = o), onChange: U }, { default: d(() => [(y(), x(Q, null, Ee(B, (o) => c(p, { key: o.K, label: o.L, value: o.V }, null, 8, ["label", "value"])), 64))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), t(e).boolPartyA ? k("", true) : (y(), Y(l, { key: 0, label: "发票及税率：", "label-width": "120px", prop: "invoiceType" }, { default: d(() => [c(Ae, { invoiceType: t(e).invoiceType, "onUpdate:invoiceType": a[2] || (a[2] = (o) => t(e).invoiceType = o), taxRate: t(e).taxRate, "onUpdate:taxRate": a[3] || (a[3] = (o) => t(e).taxRate = o), classification: t(e).materialType, class: "input-underline" }, null, 8, ["invoiceType", "taxRate", "classification"])]), _: 1 }))]), _: 1 }), c(h, { style: { "margin-top": "20px" } }, { default: d(() => [X(w("div", null, a[7] || (a[7] = [w("div", { class: "my-code" }, "请选择物料类型", -1)]), 512), [[Z, t(R)(t(e).materialType)]]), X(w("div", null, [(y(), Y(ge(re.value), { ref_key: "compRef", ref: g, detail: t(e), maxHeight: t(oe) - 260, repeatList: T.value }, { filterLeft: d(() => [c(v, { modelValue: t(e).materialType, "onUpdate:modelValue": a[4] || (a[4] = (o) => t(e).materialType = o), options: S.value, size: "default", style: { "margin-bottom": "10px" }, type: "enum" }, { suffix: d(({ item: o }) => {
      var H, F, D, j, q, z, W, G, K, $;
      return [o.V & t(u).STEEL.V && ((H = t(e)[t(s).STEEL_PLATE.LIST]) == null ? void 0 : H.length) + ((F = t(e)[t(s).SECTION_STEEL.LIST]) == null ? void 0 : F.length) + ((D = t(e)[t(s).STEEL_COIL.LIST]) == null ? void 0 : D.length) + ((j = t(e)[t(s).OTHER_STEEL_MATERIALS.LIST]) == null ? void 0 : j.length) ? (y(), x("span", Be, " (" + ee(((q = t(e)[t(s).STEEL_PLATE.LIST]) == null ? void 0 : q.length) + ((z = t(e)[t(s).SECTION_STEEL.LIST]) == null ? void 0 : z.length) + ((W = t(e)[t(s).STEEL_COIL.LIST]) == null ? void 0 : W.length) + ((G = t(e)[t(s).OTHER_STEEL_MATERIALS.LIST]) == null ? void 0 : G.length)) + ") ", 1)) : k("", true), !(o.V & t(u).STEEL.V) && ((K = t(e)[t(s).V[o.V].LIST]) != null && K.length) ? (y(), x("span", Ne, " (" + ee(($ = t(e)[t(s).V[o.V].LIST]) == null ? void 0 : $.length) + ") ", 1)) : k("", true)];
    }), _: 1 }, 8, ["modelValue", "options"])]), _: 1 }, 8, ["detail", "maxHeight", "repeatList"]))], 512), [[Z, !t(R)(t(e).materialType)]])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]), c(Pe, { modelValue: C.value, "onUpdate:modelValue": a[5] || (a[5] = (o) => C.value = o), onSuccess: pe }, null, 8, ["modelValue"])], 64);
  };
} }, tt = Ce(Oe, [["__scopeId", "data-v-a6b28622"]]);
export {
  tt as default
};
