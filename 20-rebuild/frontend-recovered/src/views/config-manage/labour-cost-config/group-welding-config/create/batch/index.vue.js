import { inject as ee } from "vue";
import { ref as z } from "vue";
import { computed as E } from "vue";
import { reactive as ae } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as u } from "vue";
import { createVNode as o } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as $ } from "vue";
import { createElementVNode as p } from "vue";
import { unref as r } from "vue";
import { normalizeClass as b } from "vue";
import { Fragment as L } from "vue";
import { renderList as I } from "vue";
import { createBlock as v } from "vue";
import { normalizeStyle as B } from "vue";
import { createCommentVNode as F } from "vue";
import { onUnmounted as te } from "vue";
import { ElButton as se } from "element-plus";
import { ElTableColumn as le } from "element-plus";
import { ElOption as oe } from "element-plus";
import { ElSelect as ne } from "element-plus";
import { ElFormItem as re } from "element-plus";
import { ElInput as ie } from "element-plus";
import { ElTable as de } from "element-plus";
import { ElForm as ce } from "element-plus";
import { ElDrawer as ue } from "element-plus";
import { dZ as pe, _ as me, d_ as fe, dp as ge, em as be, d$ as _e, e2 as T, dq as ye } from "../../../../../../shared/runtime.js";
import { b as Le, p as Ie, g as ve, a as Ve } from "../../../../../../modules/project-group-welding-config-ee2755b6.js";
const he = [{ key: "assembleConfigId", label: "部件类型", verify: true }, { key: "statisticsMode", label: "选择统计模式", verify: true }, { key: "processIdList", label: "生产方式", verify: true }, { key: "measurementManner", label: "计量方式", verify: true }, { key: "organizationInsidePrice", label: "编制内单价", verify: true }, { key: "organizationOutsidePrice", label: "编制外单价", verify: true }], _ = pe(he), ze = [{ assembleConfigId: null, statisticsMode: null, processIdList: null, measurementManner: null, organizationInsidePrice: null, organizationOutsidePrice: null, partType: [], detailList: [{ comparisonOperatorOne: "", comparisonOperatorTwo: "", numberOne: "", numberTwo: "", organizationInsidePrice: "", organizationOutsidePrice: "" }] }];
const Ce = { class: "batch-container" }, Me = { class: "box-container add-container" }, Pe = { class: "item-container" }, Oe = { class: "item-container" }, ke = { class: "item-container" }, Ue = { class: "item-container" }, Ee = { key: 0, class: "item-container price-container" }, $e = { key: 0, class: "item-container" }, Te = { __name: "index", emits: ["close"], setup(Se, { expose: R, emit: j }) {
  const V = ee("projectData"), S = JSON.parse(JSON.stringify(ze)), k = z(null), h = z(false), D = z(false), A = z(null), J = E(() => V ? Le : Ie), c = ae({ tableList: S }), { errorFields: f, save: G } = fe("deep", A, c, (a) => {
    te(a);
  }), K = () => {
    c.tableList.push({ statisticsMode: null, processIdList: null, measurementManner: null, organizationInsidePrice: null, organizationOutsidePrice: null, partType: [], detailList: [{ comparisonOperatorOne: "", comparisonOperatorTwo: "", numberOne: "", numberTwo: "", organizationInsidePrice: "", organizationOutsidePrice: "" }] }), c.tableList.forEach((a) => {
      a.componentArray = C.value;
    });
  }, q = (a) => {
    c.tableList.splice(a, 1);
  }, H = () => {
    G(async () => {
      try {
        if (k.value) c.tableList.forEach((t) => {
          t.statisticsConfigStatisticsMode = k;
        });
        else return T("error", "请先前往统计配置页面配置模式");
        V != null && V.contractProjectId && c.tableList.forEach((t) => {
          t.contractProjectId = V.contractProjectId;
        });
        const a = JSON.parse(JSON.stringify(c.tableList));
        a.forEach((t) => {
          t.processIdList = [t.processIdList];
        }), await J.value(ye(a)), T("success", "创建成功"), h.value = false;
      } catch (a) {
        console.log(a);
      }
    });
  }, Q = j, W = () => {
    Q("close");
  }, C = z([]);
  (async () => {
    try {
      const { content: a } = await ve();
      if (a.length === 0) return T("warning", "暂无部件分类");
      C.value = a;
    } catch (a) {
      console.log(a);
    }
  })(), (async () => {
    try {
      const a = await Ve();
      a.id && (k.value = a.mode);
    } catch (a) {
      console.log(a);
    }
  })();
  const Z = { assembleConfigId: ["statisticsMode", "processIdList", "measurementManner"], statisticsMode: ["processIdList", "measurementManner"] }, N = (a, t) => {
    const m = Z[t];
    m && m.forEach((d) => {
      Array.isArray(a[d]) ? a[d].splice(0) : a[d] = null;
    });
  }, x = (a) => {
    var t;
    N(a, "assembleConfigId"), a.processGroupList = ((t = C.value.find((m) => m.typeId === a.assembleConfigId)) == null ? void 0 : t.processList) || [];
  };
  return E(() => c.tableList.some((a) => a.statisticsMode !== 2)), E(() => c.tableList.some((a) => a.pricingManner)), R({ visible: h }), (a, t) => {
    const m = se, d = le, M = oe, P = ne, g = re, O = ie, X = de, Y = ce, w = ue;
    return i(), u("div", Ce, [o(w, { size: "100%", modelValue: h.value, "onUpdate:modelValue": t[1] || (t[1] = (s) => h.value = s), "close-on-press-escape": false, "close-on-click-modal": false, "show-close": false, "destroy-on-close": "", onClosed: W }, { header: l(() => [o(ge, { "header-title": "组焊配置", "type-one": false }), o(m, { plain: "", onClick: t[0] || (t[0] = (s) => h.value = false) }, { default: l(() => t[2] || (t[2] = [$("关闭")])), _: 1, __: [2] }), o(m, { type: "success", loadingz: D.value, onClick: H }, { default: l(() => t[3] || (t[3] = [$("创建")])), _: 1, __: [3] }, 8, ["loadingz"])]), default: l(() => [p("div", Me, [o(m, { type: "primary", icon: "el-icon-plus", onClick: K }, { default: l(() => t[4] || (t[4] = [$("添加更多")])), _: 1, __: [4] })]), o(Y, { model: c, ref_key: "formRef", ref: A }, { default: l(() => [o(X, { data: c.tableList, border: "", fit: "" }, { default: l(() => [o(d, { type: "index", label: "序号", align: "center", width: "60" }), o(d, { align: "center" }, { header: l(() => t[5] || (t[5] = [p("span", { class: "prop-span" }, "部件类型", -1)])), default: l(({ row: s, $index: n }) => [p("div", Pe, [o(g, { prop: `tableList.${n}.assembleConfigId`, rules: r(_).assembleConfigId, class: b({ "error-placeholder": r(f)[`tableList.${n}.assembleConfigId`] }) }, { default: l(() => [o(P, { clearable: "", modelValue: s.assembleConfigId, "onUpdate:modelValue": (e) => s.assembleConfigId = e, filterable: "", placeholder: "请选择部件类型", onChange: (e) => x(s) }, { default: l(() => [(i(true), u(L, null, I(C.value, (e) => (i(), v(M, { label: e.typeName, key: e.typeId, value: e.typeId }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 2 }, 1032, ["prop", "rules", "class"])])]), _: 1 }), o(d, { align: "center" }, { header: l(() => t[6] || (t[6] = [p("span", { class: "prop-span" }, "统计模式", -1)])), default: l(({ row: s, $index: n }) => [p("div", Oe, [o(g, { prop: `tableList.${n}.statisticsMode`, rules: r(_).statisticsMode, class: b({ "error-placeholder": r(f)[`tableList.${n}.statisticsMode`] }) }, { default: l(() => [o(P, { onChange: (e) => N(s, "statisticsMode"), placeholder: "请选择统计模式", clearable: "", modelValue: s.statisticsMode, "onUpdate:modelValue": (e) => s.statisticsMode = e }, { default: l(() => [(i(true), u(L, null, I(r(be).V, (e) => (i(), v(M, { label: e.L, key: e.K, value: e.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["onChange", "modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop", "rules", "class"])])]), _: 1 }), o(d, { align: "center" }, { header: l(() => t[7] || (t[7] = [p("span", { class: "prop-span" }, "生产工序", -1)])), default: l(({ row: s, $index: n }) => [p("div", ke, [o(g, { prop: `tableList.${n}.processIdList`, rules: r(_).processIdList, class: b({ "error-placeholder": r(f)[`tableList.${n}.processIdList`] }) }, { default: l(() => [o(P, { modelValue: s.processIdList, "onUpdate:modelValue": (e) => s.processIdList = e, placeholder: "请选择生产工序", clearable: "" }, { default: l(() => [(i(true), u(L, null, I(s.processGroupList, (e) => (i(), v(M, { key: e.id, value: e.id, label: e.name }, null, 8, ["value", "label"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop", "rules", "class"])])]), _: 1 }), o(d, { align: "center" }, { header: l(() => t[8] || (t[8] = [p("span", { class: "prop-span" }, "计量方式", -1)])), default: l(({ row: s, $index: n }) => [p("div", Ue, [o(g, { prop: `tableList.${n}.measurementManner`, rules: r(_).measurementManner, class: b({ "error-placeholder": r(f)[`tableList.${n}.measurementManner`] }) }, { default: l(() => [o(P, { placeholder: "请选择计量方式", clearable: "", modelValue: s.measurementManner, "onUpdate:modelValue": (e) => s.measurementManner = e }, { default: l(() => [(i(true), u(L, null, I(r(_e).V, (e) => (i(), v(M, { label: e.L, key: e.K, value: e.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop", "rules", "class"])])]), _: 1 }), o(d, { align: "center" }, { header: l(() => t[9] || (t[9] = [p("span", { class: "prop-span" }, "编制内价格 (元)", -1)])), default: l(({ row: s, $index: n }) => [s.pricingManner ? (i(true), u(L, { key: 1 }, I(s.detailList, (e, y) => (i(), u("div", { style: B({ "margin-bottom": s.detailList.length > 1 ? "5px" : "0" }), class: "input-item", key: y }, [o(g, { prop: `tableList.${n}.detailList.${y}.organizationInsidePrice`, rules: r(_).organizationInsidePrice, class: b({ "error-placeholder": r(f)[`tableList.${n}.detailList.${y}.organizationInsidePrice`] }) }, { default: l(() => [o(O, { placeholder: "请输入单价", modelValue: e.organizationInsidePrice, "onUpdate:modelValue": (U) => e.organizationInsidePrice = U, modelModifiers: { number: true }, clearable: "", size: "default", type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop", "rules", "class"])], 4))), 128)) : (i(), u("div", Ee, [o(g, { prop: `tableList.${n}.organizationInsidePrice`, rules: r(_).organizationInsidePrice, class: b({ "error-placeholder": r(f)[`tableList.${n}.organizationInsidePrice`] }) }, { default: l(() => [o(O, { type: "number", placeholder: "请输入单价", modelValue: s.organizationInsidePrice, "onUpdate:modelValue": (e) => s.organizationInsidePrice = e, modelModifiers: { number: true }, clearable: "" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop", "rules", "class"])]))]), _: 1 }), o(d, { align: "center" }, { header: l(() => t[10] || (t[10] = [p("span", { class: "prop-span" }, "编制外单价 (元)", -1)])), default: l(({ row: s, $index: n }) => [s.pricingManner ? (i(true), u(L, { key: 1 }, I(s.detailList, (e, y) => (i(), u("div", { style: B({ "margin-bottom": s.detailList.length > 1 ? "5px" : "0" }), class: "input-item", key: y }, [o(g, { prop: `tableList.${n}.detailList.${y}.organizationOutsidePrice`, rules: r(_).organizationOutsidePrice, class: b({ "error-placeholder": r(f)[`tableList.${n}.detailList.${y}.organizationOutsidePrice`] }) }, { default: l(() => [o(O, { type: "number", placeholder: "请输入单价", modelValue: e.organizationOutsidePrice, "onUpdate:modelValue": (U) => e.organizationOutsidePrice = U, modelModifiers: { number: true }, clearable: "", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["prop", "rules", "class"])], 4))), 128)) : (i(), u("div", $e, [o(g, { prop: `tableList.${n}.organizationOutsidePrice`, rules: r(_).organizationOutsidePrice, class: b({ "error-placeholder": r(f)[`tableList.${n}.organizationOutsidePrice`] }) }, { default: l(() => [o(O, { type: "number", placeholder: "请输入单价", modelValue: s.organizationOutsidePrice, "onUpdate:modelValue": (e) => s.organizationOutsidePrice = e, modelModifiers: { number: true }, onBlur: (e) => a.handleBlur(`tableList.${n}.organizationOutsidePrice`) }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), _: 2 }, 1032, ["prop", "rules", "class"])]))]), _: 1 }), r(S).length > 1 ? (i(), v(d, { key: 0, label: "操作", align: "center", width: "80" }, { default: l(({ $index: s }) => [s > 0 ? (i(), v(m, { key: 0, icon: "el-icon-delete", type: "danger", onClick: (n) => q(s) }, null, 8, ["onClick"])) : F("", true)]), _: 1 })) : F("", true)]), _: 1 }, 8, ["data"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, je = me(Te, [["__scopeId", "data-v-6ab38111"]]);
export {
  je as default
};
