import { ref as O } from "vue";
import { reactive as K } from "vue";
import { computed as j } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as c } from "vue";
import { createVNode as i } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as $ } from "vue";
import { createElementVNode as u } from "vue";
import { unref as o } from "vue";
import { normalizeClass as V } from "vue";
import { Fragment as b } from "vue";
import { renderList as f } from "vue";
import { createBlock as m } from "vue";
import { toDisplayString as de } from "vue";
import { createCommentVNode as k } from "vue";
import { normalizeStyle as E } from "vue";
import { ElButton as ce } from "element-plus";
import { ElTableColumn as ue } from "element-plus";
import { ElOption as pe } from "element-plus";
import { ElSelect as me } from "element-plus";
import { ElFormItem as be } from "element-plus";
import { ElInput as fe } from "element-plus";
import { ElTable as ge } from "element-plus";
import { ElForm as _e } from "element-plus";
import { ElDrawer as ye } from "element-plus";
import { dZ as Le, _ as he, d_ as ve, dp as Ve, e8 as Pe, e9 as Me, d$ as ke, eh as Ie, e0 as Ce, e1 as Te, e2 as B, dq as ze } from "../../../../../../shared/runtime.js";
import { p as Oe, a as $e, b as Be, g as Ue } from "../../../../../../modules/cutting-config-59e818a6.js";
const Ee = [{ key: "machinePartType", label: "零件类型", verify: true }, { key: "steelClassificationId", label: "零件分类", verify: true }, { key: "specificationPrefixType", label: "规格前缀类型" }, { key: "statisticsMode", label: "选择统计模式", verify: true }, { key: "processIdList", label: "生产方式", verify: true }, { key: "measurementManner", label: "计量方式", verify: true }, { key: "organizationInsidePrice", label: "编制内单价", verify: true }, { key: "organizationOutsidePrice", label: "编制外单价", verify: true }], P = Le(Ee), Se = [{ machinePartType: "", steelClassificationId: "", statisticsMode: "", processIdList: [], measurementManner: "", organizationInsidePrice: "", organizationOutsidePrice: "", partType: [], detailList: [{ comparisonOperatorOne: "", comparisonOperatorTwo: "", numberOne: "", numberTwo: "", organizationInsidePrice: "", organizationOutsidePrice: "" }] }];
const Ae = { class: "batch-container" }, De = { class: "box-container add-container" }, Ne = { class: "item-container" }, Fe = { class: "item-container" }, Re = { key: 0 }, Ke = { key: 1 }, je = { class: "item-container" }, Ge = { class: "item-container" }, Je = { class: "item-container" }, Ye = { class: "item" }, qe = { class: "item" }, He = { class: "item" }, Qe = { class: "item" }, We = { key: 0, class: "addBtn-container" }, Xe = { key: 1, class: "addBtn-container" }, Ze = { key: 0, class: "item-container price-container" }, xe = { key: 0, class: "item-container" }, we = { __name: "index", emits: ["close"], setup(ea, { expose: G, emit: J }) {
  const S = JSON.parse(JSON.stringify(Se)), U = O(null), C = O(false), Y = O(false), A = O(null), T = K({ productionMethodList: [] }), D = O(""), y = K({ tableList: S }), { errorFields: L, save: q, handleBlur: h } = ve("deep", A, y), H = () => {
    y.tableList.push({ machinePartType: "", steelClassificationId: "", statisticsMode: "", processIdList: [], measurementManner: "", organizationInsidePrice: "", organizationOutsidePrice: "", partType: [], detailList: [{ comparisonOperatorOne: "", comparisonOperatorTwo: "", numberOne: "", numberTwo: "", organizationInsidePrice: "", organizationOutsidePrice: "" }] });
  }, Q = (a) => {
    y.tableList.splice(a, 1);
  }, W = (a) => {
    N(a), a.statisticsMode === 2 && (a.processIdList.splice(0), a.pricingManner = "");
  }, N = (a) => {
    a.processIdList.splice(0), a.measurementManner = "", a.pricingManner = "", R(a), a.organizationInsidePrice = "", a.organizationOutsidePrice = "", a.detailList.forEach((n) => {
      n.organizationInsidePrice = "", n.organizationOutsidePrice = "";
    });
  }, X = () => {
    q(async () => {
      try {
        if (U.value) y.tableList.forEach((a) => {
          a.statisticsConfigStatisticsMode = U;
        });
        else return B("error", "请先前往统计配置页面配置模式");
        await Oe(ze(y.tableList)), B("success", "创建成功"), x();
      } catch (a) {
        console.log(a);
      }
    });
  }, Z = J, x = () => {
    C.value = false, Z("close");
  }, w = async () => {
    try {
      const a = await Be();
      if (a.length === 0) return T.productionMethodList.splice(0), B("warning", "该类型下暂无生产方式");
      T.productionMethodList = a;
    } catch (a) {
      console.log(a);
    }
  };
  (async () => {
    try {
      const a = await $e();
      a.id && (U.value = a.mode);
    } catch (a) {
      console.log(a);
    }
  })();
  const ee = async (a) => {
    const { content: n } = await Ue({ productClassificationEnum: a.machinePartType });
    if (n.length === 0) {
      a.partType.splice(0), B("warning", "该类型下暂无零件分类");
      return;
    }
    n.forEach((g) => {
      const p = { id: g.id, name: g.name, keyword: "" };
      g.links.forEach((_) => {
        p.keyword += `【 ${_.keyword} 】`;
      }), a.partType.push(p);
    });
  }, ae = (a) => {
    N(a), a.steelClassificationId = "", a.specificationPrefixType = "", a.partType.splice(0), T.productionMethodList.splice(0), a.statisticsMode = "", D.value = "", a.machinePartType && (ee(a), w());
  }, F = j(() => y.tableList.some((a) => a.statisticsMode !== 2)), te = j(() => y.tableList.some((a) => a.pricingManner)), le = (a) => {
    a.partType.forEach((n) => {
      n.id === a.steelClassificationId && (a.specificationPrefixType = n.keyword);
    });
  }, R = (a) => {
    a.pricingManner || a.detailList.splice(1), D.value = a.pricingManner;
  }, se = (a) => {
    a.push({ comparisonOperatorOne: "", comparisonOperatorTwo: "", numberOne: "", numberTwo: "", organizationInsidePrice: "", organizationOutsidePrice: "" });
  }, ne = (a, n) => {
    a.splice(n, 1);
  };
  return G({ visible: C }), (a, n) => {
    const g = ce, p = ue, _ = pe, M = me, v = be, I = fe, ie = ge, oe = _e, re = ye;
    return r(), c("div", Ae, [i(re, { size: "100%", modelValue: C.value, "onUpdate:modelValue": n[1] || (n[1] = (e) => C.value = e), "close-on-press-escape": false, "close-on-click-modal": false, "show-close": false, "destroy-on-close": "" }, { header: s(() => [i(Ve, { "header-title": "下料配置", "type-one": false }), i(g, { plain: "", onClick: n[0] || (n[0] = (e) => C.value = false) }, { default: s(() => n[2] || (n[2] = [$("关闭")])), _: 1, __: [2] }), i(g, { type: "success", loadingz: Y.value, onClick: X }, { default: s(() => n[3] || (n[3] = [$("创建")])), _: 1, __: [3] }, 8, ["loadingz"])]), default: s(() => [u("div", De, [i(g, { type: "primary", icon: "el-icon-plus", onClick: H }, { default: s(() => n[4] || (n[4] = [$("添加更多")])), _: 1, __: [4] })]), i(oe, { model: y, ref_key: "formRef", ref: A }, { default: s(() => [i(ie, { data: y.tableList, border: "", fit: "" }, { default: s(() => [i(p, { type: "index", label: "序号", align: "center", width: "60" }), i(p, { align: "center" }, { header: s(() => n[5] || (n[5] = [u("span", { class: "prop-span" }, "零件类型", -1)])), default: s(({ row: e, $index: l }) => [u("div", Ne, [i(v, { prop: `tableList.${l}.machinePartType`, rules: o(P).machinePartType, class: V({ "error-placeholder": o(L)[`tableList.${l}.machinePartType`] }) }, { default: s(() => [i(M, { clearable: "", modelValue: e.machinePartType, "onUpdate:modelValue": (t) => e.machinePartType = t, placeholder: "请选择零件类型", onChange: (t) => ae(e), onBlur: (t) => o(h)(`tableList.${l}.machinePartType`) }, { default: s(() => [(r(true), c(b, null, f(o(Pe).V, (t) => (r(), m(_, { label: t.L, key: t.K, value: t.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onChange", "onBlur"])]), _: 2 }, 1032, ["prop", "rules", "class"])])]), _: 1 }), i(p, { align: "center" }, { header: s(() => n[6] || (n[6] = [u("span", { class: "prop-span" }, "零件分类", -1)])), default: s(({ row: e, $index: l }) => [u("div", Fe, [i(v, { prop: `tableList.${l}.steelClassificationId`, rules: o(P).steelClassificationId, class: V({ "error-placeholder": o(L)[`tableList.${l}.steelClassificationId`] }) }, { default: s(() => [i(M, { onChange: (t) => le(e), clearable: "", modelValue: e.steelClassificationId, "onUpdate:modelValue": (t) => e.steelClassificationId = t, placeholder: "请选择零件分类", disabled: e.partType.length === 0, onBlur: (t) => o(h)(`tableList.${l}.steelClassificationId`) }, { default: s(() => [(r(true), c(b, null, f(e.partType, (t) => (r(), m(_, { key: t.id, label: t.name, value: t.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["onChange", "modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), _: 2 }, 1032, ["prop", "rules", "class"])])]), _: 1 }), i(p, { align: "center", label: "规格前缀类型" }, { default: s(({ row: e }) => [e.specificationPrefixType ? (r(), c("span", Re, de(e.specificationPrefixType), 1)) : (r(), c("span", Ke, "-"))]), _: 1 }), i(p, { align: "center" }, { header: s(() => n[7] || (n[7] = [u("span", { class: "prop-span" }, "统计模式", -1)])), default: s(({ row: e, $index: l }) => [u("div", je, [i(v, { prop: `tableList.${l}.statisticsMode`, rules: o(P).statisticsMode, class: V({ "error-placeholder": o(L)[`tableList.${l}.statisticsMode`] }) }, { default: s(() => [i(M, { onChange: (t) => W(e), placeholder: "请选择统计模式", clearable: "", modelValue: e.statisticsMode, "onUpdate:modelValue": (t) => e.statisticsMode = t, onBlur: (t) => o(h)(`tableList.${l}.statisticsMode`) }, { default: s(() => [(r(true), c(b, null, f(o(Me).V, (t) => (r(), m(_, { label: t.L, key: t.K, value: t.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["onChange", "modelValue", "onUpdate:modelValue", "onBlur"])]), _: 2 }, 1032, ["prop", "rules", "class"])])]), _: 1 }), i(p, { align: "center" }, { header: s(() => n[8] || (n[8] = [u("span", { class: "prop-span" }, "生产方式", -1)])), default: s(({ row: e, $index: l }) => [u("div", Ge, [i(v, { prop: e.statisticsMode === 2 ? "" : `tableList.${l}.processIdList`, rules: e.statisticsMode === 2 ? "" : o(P).processIdList, class: V({ "error-placeholder": e.statisticsMode === 2 ? false : o(L)[`tableList.${l}.processIdList`] }) }, { default: s(() => [i(M, { modelValue: e.processIdList, "onUpdate:modelValue": (t) => e.processIdList = t, placeholder: "请选择生产方式", clearable: "", multiple: "", disabled: e.statisticsMode === 2 || T.productionMethodList.length === 0, onBlur: (t) => o(h)(`tableList.${l}.processIdList`) }, { default: s(() => [(r(true), c(b, null, f(T.productionMethodList, (t) => (r(), m(_, { key: t.id, value: t.id, label: t.name }, null, 8, ["value", "label"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onBlur"])]), _: 2 }, 1032, ["prop", "rules", "class"])])]), _: 1 }), i(p, { align: "center" }, { header: s(() => n[9] || (n[9] = [u("span", { class: "prop-span" }, "计量方式", -1)])), default: s(({ row: e, $index: l }) => [u("div", Je, [i(v, { prop: `tableList.${l}.measurementManner`, rules: o(P).measurementManner, class: V({ "error-placeholder": o(L)[`tableList.${l}.measurementManner`] }) }, { default: s(() => [i(M, { placeholder: "请选择计量方式", clearable: "", modelValue: e.measurementManner, "onUpdate:modelValue": (t) => e.measurementManner = t, onBlur: (t) => o(h)(`tableList.${l}.measurementManner`) }, { default: s(() => [(r(true), c(b, null, f(o(ke).V, (t) => (r(), m(_, { label: t.L, key: t.K, value: t.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onBlur"])]), _: 2 }, 1032, ["prop", "rules", "class"])])]), _: 1 }), F.value ? (r(), m(p, { key: 0, label: "板厚/孔径", align: "center" }, { default: s(({ row: e }) => [i(M, { modelValue: e.pricingManner, "onUpdate:modelValue": (l) => e.pricingManner = l, placeholder: "请选择板厚/孔径", clearable: "", disabled: e.statisticsMode === 2, onChange: (l) => R(e) }, { default: s(() => [(r(true), c(b, null, f(o(Ie).V, (l) => (r(), m(_, { key: l.V, value: l.V, label: l.L }, null, 8, ["value", "label"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"])]), _: 1 })) : k("", true), n[14] || (n[14] = $(" // 板厚/孔径 ")), te.value && F.value ? (r(), m(p, { key: 1, align: "center", "min-width": "200" }, { header: s(() => n[10] || (n[10] = [u("span", null, "板厚 (mm)", -1)])), default: s(({ row: e }) => [e.pricingManner ? (r(true), c(b, { key: 0 }, f(e.detailList, (l, t) => (r(), c("div", { key: t, class: "Radius-container", style: E({ "margin-bottom": e.detailList.length > 1 ? "5px" : "0" }) }, [u("div", Ye, [i(I, { modelValue: l.numberOne, "onUpdate:modelValue": (d) => l.numberOne = d, modelModifiers: { number: true }, placeholder: "数字", type: "number", clearable: "", disabled: e.statisticsMode === 2 }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), u("div", qe, [i(M, { modelValue: l.comparisonOperatorOne, "onUpdate:modelValue": (d) => l.comparisonOperatorOne = d, clearable: "", disabled: e.statisticsMode === 2 }, { default: s(() => [(r(true), c(b, null, f(o(Ce).V, (d) => (r(), m(_, { key: d.V, label: d.L, value: d.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), n[11] || (n[11] = u("div", { class: "item" }, [u("span", { class: "station-text" }, "X")], -1)), u("div", He, [i(M, { modelValue: l.comparisonOperatorTwo, "onUpdate:modelValue": (d) => l.comparisonOperatorTwo = d, clearable: "", disabled: e.statisticsMode === 2 }, { default: s(() => [(r(true), c(b, null, f(o(Te).V, (d) => (r(), m(_, { key: d.V, label: d.L, value: d.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), u("div", Qe, [i(I, { placeholder: "数字", type: "number", clearable: "", modelValue: l.numberTwo, "onUpdate:modelValue": (d) => l.numberTwo = d, modelModifiers: { number: true }, disabled: e.statisticsMode === 2 }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), t === 0 ? (r(), c("div", We, [i(g, { icon: "el-icon-plus", type: "primary", plain: "", size: "default", onClick: (d) => se(e.detailList) }, null, 8, ["onClick"])])) : k("", true), t !== 0 ? (r(), c("div", Xe, [i(g, { icon: "el-icon-delete", type: "danger", plain: "", size: "default", onClick: (d) => ne(e.detailList, t) }, null, 8, ["onClick"])])) : k("", true)], 4))), 128)) : k("", true)]), _: 1 })) : k("", true), i(p, { align: "center" }, { header: s(() => n[12] || (n[12] = [u("span", { class: "prop-span" }, "编制内价格 (元)", -1)])), default: s(({ row: e, $index: l }) => [e.pricingManner ? (r(true), c(b, { key: 1 }, f(e.detailList, (t, d) => (r(), c("div", { style: E({ "margin-bottom": e.detailList.length > 1 ? "5px" : "0" }), class: "input-item", key: d }, [i(v, { prop: `tableList.${l}.detailList.${d}.organizationInsidePrice`, rules: o(P).organizationInsidePrice, class: V({ "error-placeholder": o(L)[`tableList.${l}.detailList.${d}.organizationInsidePrice`] }) }, { default: s(() => [i(I, { placeholder: "请输入单价", modelValue: t.organizationInsidePrice, "onUpdate:modelValue": (z) => t.organizationInsidePrice = z, modelModifiers: { number: true }, clearable: "", size: "default", type: "number", onBlur: (z) => o(h)(`tableList.${l}.detailList.${d}.organizationInsidePrice`) }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), _: 2 }, 1032, ["prop", "rules", "class"])], 4))), 128)) : (r(), c("div", Ze, [i(v, { prop: `tableList.${l}.organizationInsidePrice`, rules: o(P).organizationInsidePrice, class: V({ "error-placeholder": o(L)[`tableList.${l}.organizationInsidePrice`] }) }, { default: s(() => [i(I, { type: "number", placeholder: "请输入单价", modelValue: e.organizationInsidePrice, "onUpdate:modelValue": (t) => e.organizationInsidePrice = t, modelModifiers: { number: true }, clearable: "", onBlur: (t) => o(h)(`tableList.${l}.organizationInsidePrice`) }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), _: 2 }, 1032, ["prop", "rules", "class"])]))]), _: 1 }), i(p, { align: "center" }, { header: s(() => n[13] || (n[13] = [u("span", { class: "prop-span" }, "编制外单价 (元)", -1)])), default: s(({ row: e, $index: l }) => [e.pricingManner ? (r(true), c(b, { key: 1 }, f(e.detailList, (t, d) => (r(), c("div", { style: E({ "margin-bottom": e.detailList.length > 1 ? "5px" : "0" }), class: "input-item", key: d }, [i(v, { prop: `tableList.${l}.detailList.${d}.organizationOutsidePrice`, rules: o(P).organizationOutsidePrice, class: V({ "error-placeholder": o(L)[`tableList.${l}.detailList.${d}.organizationOutsidePrice`] }) }, { default: s(() => [i(I, { type: "number", placeholder: "请输入单价", modelValue: t.organizationOutsidePrice, "onUpdate:modelValue": (z) => t.organizationOutsidePrice = z, modelModifiers: { number: true }, clearable: "", size: "default", onBlur: (z) => o(h)(`tableList.${l}.detailList.${d}.organizationOutsidePrice`) }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), _: 2 }, 1032, ["prop", "rules", "class"])], 4))), 128)) : (r(), c("div", xe, [i(v, { prop: `tableList.${l}.organizationOutsidePrice`, rules: o(P).organizationOutsidePrice, class: V({ "error-placeholder": o(L)[`tableList.${l}.organizationOutsidePrice`] }) }, { default: s(() => [i(I, { type: "number", placeholder: "请输入单价", modelValue: e.organizationOutsidePrice, "onUpdate:modelValue": (t) => e.organizationOutsidePrice = t, modelModifiers: { number: true }, onBlur: (t) => o(h)(`tableList.${l}.organizationOutsidePrice`) }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), _: 2 }, 1032, ["prop", "rules", "class"])]))]), _: 1 }), o(S).length > 1 ? (r(), m(p, { key: 2, label: "操作", align: "center", width: "80" }, { default: s(({ $index: e }) => [e > 0 ? (r(), m(g, { key: 0, icon: "el-icon-delete", type: "danger", onClick: (l) => Q(e) }, null, 8, ["onClick"])) : k("", true)]), _: 1 })) : k("", true)]), _: 1, __: [14] }, 8, ["data"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, na = he(we, [["__scopeId", "data-v-5a565179"]]);
export {
  na as default
};
