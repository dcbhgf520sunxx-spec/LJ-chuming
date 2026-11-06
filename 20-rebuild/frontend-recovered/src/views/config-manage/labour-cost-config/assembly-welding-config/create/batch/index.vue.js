import { inject as le } from "vue";
import { ref as v } from "vue";
import { computed as B } from "vue";
import { reactive as se } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as s } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as U } from "vue";
import { createElementVNode as c } from "vue";
import { normalizeClass as k } from "vue";
import { unref as p } from "vue";
import { Fragment as y } from "vue";
import { renderList as g } from "vue";
import { createBlock as b } from "vue";
import { normalizeStyle as ne } from "vue";
import { createCommentVNode as V } from "vue";
import { onUnmounted as oe } from "vue";
import { ElButton as re } from "element-plus";
import { ElTableColumn as ie } from "element-plus";
import { ElOption as de } from "element-plus";
import { ElOptionGroup as ce } from "element-plus";
import { ElSelect as ue } from "element-plus";
import { ElFormItem as pe } from "element-plus";
import { ElInput as me } from "element-plus";
import { ElTable as fe } from "element-plus";
import { ElForm as be } from "element-plus";
import { ElDrawer as _e } from "element-plus";
import { dZ as ye, _ as ge, d_ as Le, dp as ve, d$ as Ve, e0 as Ie, e1 as he, e2 as E, dq as Oe } from "../../../../../../shared/runtime.js";
import { b as Ce, p as ke, g as Me, a as Te } from "../../../../../../modules/project-assembly-welding-config-107f9ee1.js";
const ze = [{ key: "artifactTypeId", label: "构件类型", verify: true }, { key: "artifactNameList", label: "构件名称" }, { key: "processIdList", label: "选择工序", verify: true }, { key: "pricingManner", label: "牛腿数/零件比/截面", verify: true }, { key: "measurementManner", label: "计量方式", verify: true }, { key: "organizationInsidePrice", label: "编制内单价", verify: true }, { key: "organizationOutsidePrice", label: "编制外单价", verify: true }], M = ye(ze), Pe = [{ artifactTypeId: null, artifactNameList: [], processIdList: null, measurementManner: null, detailList: [{ comparisonOperatorOne: "", comparisonOperatorTwo: "", numberOne: "", numberTwo: "", organizationInsidePrice: "", organizationOutsidePrice: "" }] }];
const Ue = { class: "batch-container" }, Ee = { class: "box-container add-container" }, Ne = { class: "item-container" }, Se = { class: "item-container" }, Ae = { class: "item-container" }, Be = { class: "item" }, $e = { class: "item" }, Re = { class: "item" }, je = { class: "item" }, De = { key: 0, class: "addBtn-container" }, Fe = { key: 1, class: "addBtn-container" }, Je = { class: "input-item" }, Ge = { class: "input-item" }, xe = { __name: "index", emits: ["close"], setup(We, { expose: $, emit: R }) {
  const I = le("projectData"), N = JSON.parse(JSON.stringify(Pe)), z = v(null), h = v(false), j = v(false), S = v(null), D = B(() => I ? Ce : ke), _ = se({ tableList: N }), { errorFields: O, save: F } = Le("deep", S, _, (t) => {
    oe(t);
  }), J = () => {
    _.tableList.push({ artifactClassification: null, artifactTypeId: null, processIdList: null, measurementManner: null, detailList: [{ comparisonOperatorOne: "", comparisonOperatorTwo: "", numberOne: "", numberTwo: "", organizationInsidePrice: "", organizationOutsidePrice: "" }] });
  }, G = (t) => {
    _.tableList.splice(t, 1);
  }, x = () => {
    F(async () => {
      try {
        if (z.value) _.tableList.forEach((e) => {
          e.statisticsConfigStatisticsMode = z;
        });
        else return E("error", "请先前往统计配置页面配置模式");
        I != null && I.contractProjectId && _.tableList.forEach((e) => {
          e.contractProjectId = I.contractProjectId;
        });
        const t = JSON.parse(JSON.stringify(_.tableList));
        t.forEach((e) => {
          e.processIdList = [e.processIdList];
        }), await D.value(Oe(t)), E("success", "创建成功"), h.value = false;
      } catch (t) {
        console.log(t);
      }
    });
  }, W = R, X = () => {
    W("close");
  }, A = v([]), P = v([]);
  (async (t) => {
    try {
      const { content: e } = await Me();
      if (e.length === 0) return E("warning", "构件暂无类型");
      const u = {};
      P.value = e, await e.forEach((r) => {
        const m = r.artifactClassification;
        u[m] || (u[m] = []), u[m].push(r);
      }), A.value = Object.entries(u).map(([r, m]) => ({ label: r === "1" ? "主构件" : "次构件", options: m }));
    } catch (e) {
      console.error("获取构件分类与工序失败:" + e);
    }
  })(), (async () => {
    try {
      const t = await Te();
      t.id && (z.value = t.mode);
    } catch (t) {
      console.log(t);
    }
  })();
  const Y = async (t) => {
    var e, u;
    await H(t, "artifactTypeId"), t.processGroupList = ((e = P.value.find((r) => r.typeId === t.artifactTypeId)) == null ? void 0 : e.processList) || [], t.artifactNameSelectList = ((u = P.value.find((r) => r.typeId === t.artifactTypeId)) == null ? void 0 : u.artifactNameList) || [], t.artifactNameList.push(...t.artifactNameSelectList);
  }, q = { artifactTypeId: ["artifactNameList", "processIdList", "measurementManner"] }, H = (t, e) => {
    const u = q[e];
    u && u.forEach((r) => {
      Array.isArray(t[r]) ? t[r].splice(0) : t[r] = null;
    });
  }, K = B(() => _.tableList.some((t) => t.pricingManner)), Q = (t) => {
    t.push({ comparisonOperatorOne: "", comparisonOperatorTwo: "", numberOne: "", numberTwo: "", organizationInsidePrice: "", organizationOutsidePrice: "" });
  }, Z = (t, e) => {
    t.splice(e, 1);
  };
  return $({ visible: h }), (t, e) => {
    const u = re, r = ie, m = de, w = ce, L = ue, C = pe, T = me, ee = fe, ae = be, te = _e;
    return i(), f("div", Ue, [s(te, { modelValue: h.value, "onUpdate:modelValue": e[1] || (e[1] = (a) => h.value = a), "close-on-click-modal": false, "close-on-press-escape": false, "show-close": false, "destroy-on-close": "", size: "100%", onClosed: X }, { header: l(() => [s(ve, { "type-one": false, "header-title": "装焊配置" }), s(u, { plain: "", onClick: e[0] || (e[0] = (a) => h.value = false) }, { default: l(() => e[2] || (e[2] = [U("关闭")])), _: 1, __: [2] }), s(u, { loadingz: j.value, type: "success", onClick: x }, { default: l(() => e[3] || (e[3] = [U("创建")])), _: 1, __: [3] }, 8, ["loadingz"])]), default: l(() => [c("div", Ee, [s(u, { icon: "el-icon-plus", type: "primary", onClick: J }, { default: l(() => e[4] || (e[4] = [U("添加更多")])), _: 1, __: [4] })]), s(ae, { ref_key: "formRef", ref: S, model: _ }, { default: l(() => [s(ee, { data: _.tableList, border: "", fit: "" }, { default: l(() => [s(r, { align: "center", label: "序号", type: "index", width: "60" }), s(r, { align: "center" }, { header: l(() => e[5] || (e[5] = [c("span", { class: "prop-span" }, "构件类型", -1)])), default: l(({ row: a, $index: n }) => [c("div", Ne, [s(C, { class: k({ "error-placeholder": p(O)[`tableList.${n}.artifactTypeId`] }), prop: `tableList.${n}.artifactTypeId`, rules: p(M).artifactTypeId }, { default: l(() => [s(L, { modelValue: a.artifactTypeId, "onUpdate:modelValue": (o) => a.artifactTypeId = o, clearable: "", filterable: "", placeholder: "请输入或选择构件类型", onChange: (o) => Y(a) }, { default: l(() => [(i(true), f(y, null, g(A.value, (o) => (i(), b(w, { key: o.label, label: o.label }, { default: l(() => [(i(true), f(y, null, g(o.options, (d) => (i(), b(m, { key: d.typeId, label: d.typeName, value: d.typeId }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["label"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 2 }, 1032, ["class", "prop", "rules"])])]), _: 1 }), s(r, { align: "center", label: "构件名称" }, { default: l(({ row: a }) => [s(L, { modelValue: a.artifactNameList, "onUpdate:modelValue": (n) => a.artifactNameList = n, clearable: "", multiple: "", placeholder: "请输入或选择构件名称" }, { default: l(() => [(i(true), f(y, null, g(a.artifactNameSelectList, (n, o) => (i(), b(m, { key: o, label: n, value: n }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(r, { align: "center" }, { header: l(() => e[6] || (e[6] = [c("span", { class: "prop-span" }, "生产工序", -1)])), default: l(({ row: a, $index: n }) => [c("div", Se, [s(C, { class: k({ "error-placeholder": p(O)[`tableList.${n}.processIdList`] }), prop: `tableList.${n}.processIdList`, rules: p(M).processIdList }, { default: l(() => [s(L, { modelValue: a.processIdList, "onUpdate:modelValue": (o) => a.processIdList = o, clearable: "", placeholder: "请选择生产工序" }, { default: l(() => [(i(true), f(y, null, g(a.processGroupList, (o) => (i(), b(m, { key: o.id, label: o.name, value: o.id }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["class", "prop", "rules"])])]), _: 1 }), s(r, { align: "center" }, { header: l(() => e[7] || (e[7] = [c("span", { class: "prop-span" }, "计量方式", -1)])), default: l(({ row: a, $index: n }) => [c("div", Ae, [s(C, { class: k({ "error-placeholder": p(O)[`tableList.${n}.measurementManner`] }), prop: `tableList.${n}.measurementManner`, rules: p(M).measurementManner }, { default: l(() => [s(L, { modelValue: a.measurementManner, "onUpdate:modelValue": (o) => a.measurementManner = o, clearable: "", placeholder: "请选择计量方式", onBlur: (o) => t.handleBlur(`tableList.${n}.measurementManner`) }, { default: l(() => [(i(true), f(y, null, g(p(Ve).V, (o) => (i(), b(m, { key: o.K, label: o.L, value: o.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onBlur"])]), _: 2 }, 1032, ["class", "prop", "rules"])])]), _: 1 }), K.value ? (i(), b(r, { key: 0, align: "center", "min-width": "200" }, { header: l(() => e[8] || (e[8] = [c("span", null, "(mm)", -1)])), default: l(({ row: a }) => [a.pricingManner ? (i(true), f(y, { key: 0 }, g(a.detailList, (n, o) => (i(), f("div", { key: o, style: ne({ "margin-bottom": a.detailList.length > 1 ? "5px" : "0" }), class: "Radius-container" }, [c("div", Be, [s(T, { modelValue: n.numberOne, "onUpdate:modelValue": (d) => n.numberOne = d, modelModifiers: { number: true }, disabled: a.statisticsMode === 2, clearable: "", placeholder: "数字", type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), c("div", $e, [s(L, { modelValue: n.comparisonOperatorOne, "onUpdate:modelValue": (d) => n.comparisonOperatorOne = d, disabled: a.statisticsMode === 2, clearable: "" }, { default: l(() => [(i(true), f(y, null, g(p(Ie).V, (d) => (i(), b(m, { key: d.V, label: d.L, value: d.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), e[9] || (e[9] = c("div", { class: "item" }, [c("span", { class: "station-text" }, "X")], -1)), c("div", Re, [s(L, { modelValue: n.comparisonOperatorTwo, "onUpdate:modelValue": (d) => n.comparisonOperatorTwo = d, disabled: a.statisticsMode === 2, clearable: "" }, { default: l(() => [(i(true), f(y, null, g(p(he).V, (d) => (i(), b(m, { key: d.V, label: d.L, value: d.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), c("div", je, [s(T, { modelValue: n.numberTwo, "onUpdate:modelValue": (d) => n.numberTwo = d, modelModifiers: { number: true }, disabled: a.statisticsMode === 2, clearable: "", placeholder: "数字", type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), o === 0 ? (i(), f("div", De, [s(u, { icon: "el-icon-plus", plain: "", size: "default", type: "primary", onClick: (d) => Q(a.detailList) }, null, 8, ["onClick"])])) : V("", true), o !== 0 ? (i(), f("div", Fe, [s(u, { icon: "el-icon-delete", plain: "", size: "default", type: "danger", onClick: (d) => Z(a.detailList, o) }, null, 8, ["onClick"])])) : V("", true)], 4))), 128)) : V("", true)]), _: 1 })) : V("", true), s(r, { align: "center" }, { header: l(() => e[10] || (e[10] = [c("span", { class: "prop-span" }, "编制内价格 (元)", -1)])), default: l(({ row: a, $index: n }) => [c("div", Je, [s(C, { class: k({ "error-placeholder": p(O)[`tableList.${n}.organizationInsidePrice`] }), prop: `tableList.${n}.organizationInsidePrice`, rules: p(M).organizationInsidePrice }, { default: l(() => [s(T, { modelValue: a.organizationInsidePrice, "onUpdate:modelValue": (o) => a.organizationInsidePrice = o, modelModifiers: { number: true }, clearable: "", placeholder: "请输入单价", size: "default", type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["class", "prop", "rules"])])]), _: 1 }), s(r, { align: "center" }, { header: l(() => e[11] || (e[11] = [c("span", { class: "prop-span" }, "编制外单价 (元)", -1)])), default: l(({ row: a, $index: n }) => [c("div", Ge, [s(C, { class: k({ "error-placeholder": p(O)[`tableList.${n}.organizationOutsidePrice`] }), prop: `tableList.${n}.organizationOutsidePrice`, rules: p(M).organizationOutsidePrice }, { default: l(() => [s(T, { modelValue: a.organizationOutsidePrice, "onUpdate:modelValue": (o) => a.organizationOutsidePrice = o, modelModifiers: { number: true }, clearable: "", placeholder: "请输入单价", size: "default", type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["class", "prop", "rules"])])]), _: 1 }), p(N).length > 1 ? (i(), b(r, { key: 1, align: "center", label: "操作", width: "80" }, { default: l(({ $index: a }) => [a > 0 ? (i(), b(u, { key: 0, icon: "el-icon-delete", type: "danger", onClick: (n) => G(a) }, null, 8, ["onClick"])) : V("", true)]), _: 1 })) : V("", true)]), _: 1 }, 8, ["data"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, Qe = ge(xe, [["__scopeId", "data-v-d9a7c46e"]]);
export {
  Qe as default
};
