import { ref as b } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as V } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as t } from "vue";
import { withCtx as l } from "vue";
import { unref as s } from "vue";
import { createBlock as x } from "vue";
import { createTextVNode as n } from "vue";
import { createCommentVNode as C } from "vue";
import { withDirectives as Q } from "vue";
import { toDisplayString as M } from "vue";
import { Fragment as k } from "vue";
import { renderList as X } from "vue";
import { ElMessageBox as Y } from "element-plus";
import { ElMessage as w } from "element-plus";
import { ElTableColumn as Z } from "element-plus";
import { ElCard as ee } from "element-plus";
import { ElTag as te } from "element-plus";
import { InfoFilled as le } from "@element-plus/icons-vue";
import { ElIcon as ae } from "element-plus";
import { ElTooltip as oe } from "element-plus";
import { ElFormItem as ne } from "element-plus";
import { ElForm as se } from "element-plus";
import { vLoading as ie } from "element-plus";
import { c as re, d as de, e as ue } from "../../../../../modules/inventory-error-config-927b9f3e.js";
import { _ as me, x as pe, fr as j, a3 as T, G as E, fv as ce, P as fe, c as B, V as ge } from "../../../../../shared/runtime.js";
import _e from "./module/form.vue.js";
const he = { class: "wrap" }, ye = { class: "header" }, be = { key: 1 }, ve = { class: "right-header" }, Ve = { class: "type-title" }, xe = { class: "form-list" }, Me = { __name: "index", setup(Te) {
  const A = b(false), O = b(), c = b(), { crud: m, CRUD: L } = pe({ title: "项目清单误差配置", permission: { ...j }, invisibleColumns: [], crudApi: { ...re }, hasPagination: true }, O), v = b({ boolGeneralConfig: false, projectId: void 0, detailDTOList: [{ title: "构件误差", productType: T.ARTIFACT.V, length: 0, netWeight: 0, grossWeight: 0, surfaceArea: 0 }, { title: "部件误差", productType: T.ASSEMBLE.V, length: 0, netWeight: 0, grossWeight: 0, surfaceArea: 0 }, { title: "零件误差", productType: T.MACHINE_PART.V, length: 0, netWeight: 0, grossWeight: 0, thickness: 0, width: 0, surfaceArea: 0 }] });
  L.HOOK.beforeToQuery = () => {
    m.query.boolGeneralConfig = false;
  }, L.HOOK.handleRefresh = () => {
    c.value = void 0;
  };
  function W(a) {
    m.query.projectId = a, m.toQuery();
  }
  function G() {
    A.value = true;
  }
  function K(a) {
    var e;
    a && (c.value = a, v.value.projectId = a == null ? void 0 : a.projectId, a != null && a.detailDTOList.length && ((e = a == null ? void 0 : a.detailDTOList) == null || e.map((i) => (i.title = T.VL[i.productType], i.surfaceArea = i.surfaceArea && B(i.surfaceArea, "mm²", "m²"), i))), v.value.detailDTOList = JSON.parse(JSON.stringify(a == null ? void 0 : a.detailDTOList)));
  }
  async function z(a) {
    var e;
    try {
      await Y.confirm(`确认删除 【${a.projectShortName}】 误差配置？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await de({ projectId: a.projectId }), w.success("删除成功！"), m.refresh(), a.projectId === ((e = c.value) == null ? void 0 : e.projectId) && (c.value = void 0);
    } catch (i) {
      console.log(i);
    }
  }
  const N = b(), S = b(false);
  async function F() {
    try {
      if (S.value = true, !await N.value.validate()) return false;
      const e = ge(v.value);
      e.detailDTOList = P(e.detailDTOList), await ue(e), m.refresh(), w.success("保存成功！");
    } catch (a) {
      console.log(a);
    } finally {
      S.value = false;
    }
  }
  function P(a) {
    return a.map((e) => (e.surfaceArea && (e.surfaceArea = B(e.surfaceArea, "m²", "mm²")), e));
  }
  return (a, e) => {
    const i = U("common-button"), I = Z, H = U("common-table"), R = ee, D = te, f = le, g = ae, _ = oe, h = U("common-input-number"), y = ne, $ = se, q = ie;
    return u(), V(k, null, [p("div", null, [p("div", he, [t(R, { class: "wrap-left" }, { default: l(() => [p("div", ye, [s(E)(s(j).add) ? (u(), x(i, { key: 0, size: "default", type: "primary", onClick: G, style: { "margin-bottom": "10px" } }, { default: l(() => e[3] || (e[3] = [n(" 新增项目配置 ")])), _: 1, __: [3] })) : C("", true), t(s(ce), { modelValue: a.projectId, "onUpdate:modelValue": e[0] || (e[0] = (r) => a.projectId = r), class: "filter-item", style: { width: "450px" }, placeholder: "可选择项目搜索", clearable: "", onChange: W }, null, 8, ["modelValue"])]), Q((u(), x(H, { ref_key: "tableRef", ref: O, class: "painting-crud-table", data: s(m).data, "empty-text": s(m).emptyText, "max-height": a.maxHeight, "row-key": "id", style: { width: "100%", cursor: "pointer" }, "highlight-current-row": "", onCurrentChange: K }, { default: l(() => [t(I, { label: "序号", type: "index", align: "center", width: "60" }), t(I, { prop: "projectName", "show-overflow-tooltip": true, label: "项目名称", "min-width": "100", align: "center" }, { default: l((r) => [p("span", null, M(r.row.projectSerialNumber || "-") + " " + M(r.row.projectShortName || "-"), 1)]), _: 1 }), t(I, { label: "操作", width: "80", align: "center", fixed: "right" }, { default: l((r) => [s(E)(s(j).del) ? (u(), x(i, { key: 0, size: "default", icon: "el-icon-delete", type: "danger", onClick: (o) => z(r.row) }, null, 8, ["onClick"])) : C("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[q, s(m).loading]]), t(s(fe))]), _: 1 }), t(R, { class: "wrap-right" }, { default: l(() => {
      var r;
      return [(r = c.value) != null && r.projectId ? (u(), V("div", be, [p("div", ve, [p("div", null, [t(D, { size: "large" }, { default: l(() => {
        var o;
        return [n("项目编号：" + M(((o = c.value) == null ? void 0 : o.projectSerialNumber) || "-"), 1)];
      }), _: 1 }), t(D, { size: "large", style: { "margin-left": "10px" } }, { default: l(() => {
        var o;
        return [n("项目名称：" + M(((o = c.value) == null ? void 0 : o.projectShortName) || "-"), 1)];
      }), _: 1 })]), s(E)(s(j).edit) ? (u(), x(i, { key: 0, size: "default", type: "success", onClick: F }, { default: l(() => e[5] || (e[5] = [n(" 保存 ")])), _: 1, __: [5] })) : C("", true)]), t($, { ref_key: "formRef", ref: N, model: v.value, "label-width": "160px" }, { default: l(() => [(u(true), V(k, null, X(v.value.detailDTOList, (o, J) => (u(), V(k, { key: J }, [p("div", Ve, M(o.title), 1), p("div", xe, [t(y, { label: "长度（MM）：", class: "form-item" }, { label: l(() => [e[6] || (e[6] = n(" 长度（MM） ")), t(_, { class: "item", effect: "light", content: "长度最大误差100MM", placement: "top" }, { default: l(() => [t(g, null, { default: l(() => [t(f)]), _: 1 })]), _: 1 }), e[7] || (e[7] = n(" ： "))]), default: l(() => [t(h, { modelValue: o.length, "onUpdate:modelValue": (d) => o.length = d, "controls-position": "right", precision: 2, min: 0, max: 100, style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024), t(y, { label: "单净重（KG）：", class: "form-item" }, { label: l(() => [e[8] || (e[8] = n(" 单净重（KG） ")), t(_, { class: "item", effect: "light", content: "单净重最大误差100KG", placement: "top" }, { default: l(() => [t(g, null, { default: l(() => [t(f)]), _: 1 })]), _: 1 }), e[9] || (e[9] = n(" ： "))]), default: l(() => [t(h, { modelValue: o.netWeight, "onUpdate:modelValue": (d) => o.netWeight = d, "controls-position": "right", precision: 2, min: 0, max: 100, style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024), t(y, { label: "单毛重（KG）：", class: "form-item" }, { label: l(() => [e[10] || (e[10] = n(" 单毛重（KG） ")), t(_, { class: "item", effect: "light", content: "单毛重最大误差100KG", placement: "top" }, { default: l(() => [t(g, null, { default: l(() => [t(f)]), _: 1 })]), _: 1 }), e[11] || (e[11] = n(" ： "))]), default: l(() => [t(h, { modelValue: o.grossWeight, "onUpdate:modelValue": (d) => o.grossWeight = d, "controls-position": "right", precision: 2, min: 0, max: 100, style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024), o.productType === s(T).MACHINE_PART.V ? (u(), V(k, { key: 0 }, [t(y, { label: "规格（厚度 MM）" }, { label: l(() => [e[12] || (e[12] = n(" 规格（厚度 MM） ")), t(_, { class: "item", effect: "light", content: "截面厚度最大误差200MM", placement: "top" }, { default: l(() => [t(g, null, { default: l(() => [t(f)]), _: 1 })]), _: 1 }), e[13] || (e[13] = n(" ： "))]), default: l(() => [t(h, { modelValue: o.thickness, "onUpdate:modelValue": (d) => o.thickness = d, "controls-position": "right", precision: 2, min: 0, max: 200, style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024), t(y, { label: "规格（宽度 MM）" }, { label: l(() => [e[14] || (e[14] = n(" 规格（宽度 MM） ")), t(_, { class: "item", effect: "light", content: "截面宽度最大误差200MM", placement: "top" }, { default: l(() => [t(g, null, { default: l(() => [t(f)]), _: 1 })]), _: 1 }), e[15] || (e[15] = n(" ： "))]), default: l(() => [t(h, { modelValue: o.width, "onUpdate:modelValue": (d) => o.width = d, "controls-position": "right", precision: 2, min: 0, max: 200, style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024)], 64)) : C("", true), t(y, { label: "单面积（M²）：", class: "form-item" }, { label: l(() => [e[16] || (e[16] = n(" 单面积（M²） ")), t(_, { class: "item", effect: "light", content: "单面积最大误差1M²", placement: "top" }, { default: l(() => [t(g, null, { default: l(() => [t(f)]), _: 1 })]), _: 1 }), e[17] || (e[17] = n(" ： "))]), default: l(() => [t(h, { modelValue: o.surfaceArea, "onUpdate:modelValue": (d) => o.surfaceArea = d, "controls-position": "right", precision: 3, min: 0, max: 1e6, style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024)])], 64))), 128))]), _: 1 }, 8, ["model"])])) : (u(), x(D, { key: 0, type: "info", size: "large" }, { default: l(() => e[4] || (e[4] = [n(" * 请点击左侧项目列表查看配置详情 ")])), _: 1, __: [4] }))];
    }), _: 1 })])]), t(s(_e), { visible: A.value, "onUpdate:visible": e[1] || (e[1] = (r) => A.value = r), onSuccess: e[2] || (e[2] = (r) => s(m).refresh()) }, null, 8, ["visible"])], 64);
  };
} }, Ie = me(Me, [["__scopeId", "data-v-12a8e756"]]);
export {
  Ie as default
};
