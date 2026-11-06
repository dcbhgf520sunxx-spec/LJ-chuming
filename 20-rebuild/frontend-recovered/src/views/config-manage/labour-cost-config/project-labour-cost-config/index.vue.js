import { ref as f } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as v } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as n } from "vue";
import { unref as t } from "vue";
import { withDirectives as O } from "vue";
import { createBlock as s } from "vue";
import { withCtx as d } from "vue";
import { createCommentVNode as m } from "vue";
import { toDisplayString as E } from "vue";
import { createTextVNode as P } from "vue";
import { ElMessage as C } from "element-plus";
import { ElMessageBox as T } from "element-plus";
import { ElNotification as F } from "element-plus";
import { ElTableColumn as H } from "element-plus";
import { ElDatePicker as I } from "element-plus";
import { vLoading as q } from "element-plus";
import { _ as A, o as Q, x as G, ey as g, ez as u, p as D, G as k, P as K } from "../../../../shared/runtime.js";
import { c as J, _ as W, p as X, d as Y } from "./module/form.vue.js";
import Z from "./module/header.vue.js";
import ee from "./detail/index.vue.js";
import "../cutting-config/index.vue.js";
import "../cutting-config/header.vue.js";
import "../cutting-config/create/index.vue.js";
import "../cutting-config/create/calculation/index.vue.js";
import "../../../../modules/cutting-config-59e818a6.js";
import "../cutting-config/create/reverse-thrust/index.vue.js";
import "../../../../modules/project-cutting-config-562d5e35.js";
import "../cutting-config/create/batch/index.vue.js";
import "../cutting-config/table.vue.js";
import "../group-welding-config/index.vue.js";
import "../group-welding-config/header.vue.js";
import "../group-welding-config/create/index.vue.js";
import "../group-welding-config/create/calculation/index.vue.js";
import "../../../../modules/project-group-welding-config-ee2755b6.js";
import "../group-welding-config/create/reverse-thrust/index.vue.js";
import "../../../../modules/drilling-config-d5ae6cbb.js";
import "../group-welding-config/create/batch/index.vue.js";
import "../group-welding-config/table.vue.js";
import "../assembly-welding-config/index.vue.js";
import "../assembly-welding-config/header.vue.js";
import "../assembly-welding-config/create/index.vue.js";
import "../assembly-welding-config/create/calculation/index.vue.js";
import "../../../../modules/project-assembly-welding-config-107f9ee1.js";
import "../assembly-welding-config/create/reverse-thrust/index.vue.js";
import "../assembly-welding-config/create/batch/index.vue.js";
import "../assembly-welding-config/table.vue.js";
import "../stud-set/index.vue.js";
import "../../../../modules/stud-set-1d850c87.js";
import "../stud-set/module/header.vue.js";
import "../stud-set/module/form.vue.js";
const te = { class: "app-container" }, ie = { class: "head-container" }, oe = { key: 0, class: "screen" }, ae = { key: 1 }, ne = { __name: "index", setup(re) {
  const h = f(), _ = f(false), y = f(false), x = f(), { maxHeight: V } = Q({ paginate: true }), S = { add: true, edit: false, del: false, download: false }, { crud: c, CRUD: j } = G({ sort: [], title: "项目工价", optShow: { ...S }, hasPagination: true, permission: { ...g }, crudApi: { ...J } }, h);
  j.HOOK.afterRefresh = (o, i) => {
    o.data.map((a) => {
      a.configurePriceDate = [a.configPriceSyncStartDate, a.configPriceSyncEndDate], a.isEditing = false;
    });
  };
  function B(o) {
    o.isEditing = !o.isEditing;
  }
  function N(o) {
    y.value = true, x.value = o;
  }
  async function $(o) {
    _.value = true;
    try {
      await X(o, c.query), c.toQuery(), C({ message: "修改成功", type: "success" });
    } catch (i) {
      C({ message: "修改失败", type: "error" }), console.log(i);
    } finally {
      _.value = false;
    }
  }
  function R(o) {
    T.confirm("是否确认删除该项目？", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
      await Y({ projectId: o.contractProjectId }), F({ title: "删除成功", type: "success", duration: 2500 }), c.toQuery();
    }).catch((i) => {
      console.log(i, "删除失败");
    });
  }
  return (o, i) => {
    const a = H, U = w("common-select"), M = I, p = w("common-button"), z = w("common-table"), L = q;
    return r(), v("div", te, [b("div", ie, [n(t(Z))]), O((r(), s(z, { ref_key: "tableRef", ref: h, data: t(c).data, "empty-text": t(c).emptyText, "max-height": t(V), "return-source-data": "", style: { width: "100%" } }, { default: d(() => [n(a, { label: "序号", align: "center", type: "index" }), n(a, { key: "projectName", prop: "projectName", "show-overflow-tooltip": "", label: "项目名称", align: "center", width: "340px" }), n(a, { key: "statisticsModeName", prop: "statisticsModeName", "show-overflow-tooltip": "", label: "项目模式", align: "center", width: "140px" }), n(a, { key: "statisticsDeadline", prop: "statisticsDeadline", label: "统计截止日", align: "center", width: "240px" }, { default: d((e) => [i[1] || (i[1] = b("div", null, "月底", -1))]), _: 1 }), n(a, { key: "configurePriceScreen", prop: "configurePriceScreen", label: "配置价格修改场景", align: "center" }, { default: d((e) => [e.row.isEditing ? (r(), v("div", oe, [n(U, { modelValue: e.row.configPrice, "onUpdate:modelValue": (l) => e.row.configPrice = l, options: t(u).ENUM, type: "enum", disabledVal: [t(u).BEFOR.V], disabled: !e.row.isEditing, style: { width: "240px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabledVal", "disabled"]), e.row.configPrice === t(u).BEFOR.V ? (r(), s(M, { key: 0, type: "daterange", "range-separator": ":", "value-format": "x", "start-placeholder": "开始日期", "end-placeholder": "结束日期", modelValue: e.row.configurePriceDate, "onUpdate:modelValue": (l) => e.row.configurePriceDate = l, disabled: !e.row.isEditing, style: { width: "400px", "margin-left": "10px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])) : m("", true)])) : (r(), v("span", ae, E(t(u).VL[e.row.configPrice]) + " " + E(e.row.configPrice === t(u).BEFOR.V && e.row.configurePriceDate ? ` ${t(D)(e.row.configPriceSyncStartDate, "{y}-{m}-{d}")}  -
                ${t(D)(e.row.configPriceSyncEndDate, "{y}-{m}-{d}")}` : ""), 1))]), _: 1 }), n(a, { key: "options", label: "操作", align: "center", width: "280" }, { default: d((e) => [!e.row.isEditing && t(k)(t(g).setting) ? (r(), s(p, { key: 0, size: "default", icon: "el-icon-setting", type: "primary", onClick: (l) => N(e.row) }, null, 8, ["onClick"])) : m("", true), !e.row.isEditing && t(k)(t(g).edit) ? (r(), s(p, { key: 1, icon: "el-icon-edit", size: "default", type: "primary", onClick: (l) => B(e.row) }, null, 8, ["onClick"])) : m("", true), !e.row.isEditing && t(k)(t(g).del) ? (r(), s(p, { key: 2, icon: "el-icon-delete", size: "default", type: "danger", onClick: (l) => R(e.row) }, null, 8, ["onClick"])) : m("", true), e.row.isEditing ? (r(), s(p, { key: 3, loading: _.value, size: "default", type: "success", onClick: (l) => $(e.row) }, { default: d(() => i[2] || (i[2] = [P(" 确认 ")])), _: 2, __: [2] }, 1032, ["loading", "onClick"])) : m("", true), e.row.isEditing ? (r(), s(p, { key: 4, size: "default", type: "primary", onClick: (l) => e.row.isEditing = !e.row.isEditing }, { default: d(() => i[3] || (i[3] = [P(" 取消 ")])), _: 2, __: [3] }, 1032, ["onClick"])) : m("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[L, t(c).loading]]), n(t(K)), n(ee, { visible: y.value, "onUpdate:visible": i[0] || (i[0] = (e) => y.value = e), projectData: x.value }, null, 8, ["visible", "projectData"]), n(t(W))]);
  };
} }, Ie = A(ne, [["__scopeId", "data-v-02cfeae7"]]);
export {
  Ie as default
};
