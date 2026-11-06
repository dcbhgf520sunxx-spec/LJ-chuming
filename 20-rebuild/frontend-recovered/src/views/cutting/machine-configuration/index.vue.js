import { ref as g } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as c } from "vue";
import { unref as a } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as r } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as n } from "vue";
import { ElTableColumn as v } from "element-plus";
import { vLoading as T } from "element-plus";
import { e as N } from "../../../modules/machine-10301ee2.js";
import { x as C, o as L, lY as u, l$ as U, G as A, an as E, P as I } from "../../../shared/runtime.js";
import V from "./module/form.vue.js";
import P from "./module/header.vue.js";
import { m as _ } from "../../../modules/cutting-457c256f.js";
import "../../../modules/factory-select-b8d0a4ac.js";
import "../../../modules/production-line-select-f08e245b.js";
import "../../../modules/index-7da9f094.js";
import "../../../modules/use-users-4d979987.js";
const B = { class: "app-container" }, D = { key: 0 }, M = { key: 1 }, R = { key: 2 }, W = { __name: "index", setup(S) {
  const h = g(), f = { add: true, edit: false, del: false, download: false }, { crud: d, columns: l } = C({ title: "机器配置", sort: [], permission: { ..._ }, optShow: { ...f }, crudApi: { ...N }, hasPagination: true }, h), { maxHeight: w } = L({ wrapperBox: ".contractRecord", paginate: true, extraHeight: 40 });
  return (G, H) => {
    const i = v, b = x("common-table"), y = T;
    return t(), m("div", B, [c(a(P)), k((t(), r(b, { ref_key: "tableRef", ref: h, data: a(d).data, "empty-text": a(d).emptyText, "max-height": a(w), style: { width: "100%" } }, { default: o(() => [c(i, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(l).visible("factory") ? (t(), r(i, { align: "center", key: "factory", prop: "factory", label: "工厂", "min-width": "40px" }, { default: o((e) => [p("span", null, s(e.row.factory), 1)]), _: 1 })) : n("", true), a(l).visible("workshopInf") ? (t(), r(i, { key: "workshopInf", prop: "workshopInf", label: "车间", "min-width": "45px", align: "center" }, { default: o((e) => [p("span", null, s(e.row.workshopInf), 1)]), _: 1 })) : n("", true), a(l).visible("productionLine") ? (t(), r(i, { key: "productionLine", prop: "productionLine", label: "生产线", "min-width": "45px", align: "center" }, { default: o((e) => [p("span", null, s(e.row.productionLine), 1)]), _: 1 })) : n("", true), a(l).visible("machineType") ? (t(), r(i, { key: "machineType", prop: "machineType", label: "设备类型", "min-width": "45px", align: "center" }, { default: o((e) => [e.row.machineType === a(u).FLAME_CUTTING.V ? (t(), m("span", D, "火焰切割设备")) : n("", true), e.row.machineType === a(u).PLASMA_CUTTING.V ? (t(), m("span", M, "等离子切割设备")) : n("", true), e.row.machineType === a(u).LASER_CUTTING.V ? (t(), m("span", R, "激光切割设备")) : n("", true)]), _: 1 })) : n("", true), a(l).visible("machineName") ? (t(), r(i, { key: "machineName", prop: "machineName", label: "设备名称", "min-width": "40px", align: "center" }, { default: o((e) => [p("span", null, s(e.row.machineName), 1)]), _: 1 })) : n("", true), a(l).visible("brand") ? (t(), r(i, { key: "brand", prop: "brand", label: "设备品牌", "min-width": "40px", align: "center" }, { default: o((e) => [p("span", null, s(e.row.brand), 1)]), _: 1 })) : n("", true), a(l).visible("machineNumber") ? (t(), r(i, { align: "center", key: "machineNumber", prop: "machineNumber", label: "设备编号", "min-width": "40px" }, { default: o((e) => [p("span", null, s(e.row.machineNumber), 1)]), _: 1 })) : n("", true), a(l).visible("director") ? (t(), r(i, { key: "director", prop: "director", label: "负责人", "min-width": "40px", align: "center" }, { default: o((e) => [p("span", null, s(e.row.director), 1)]), _: 1 })) : n("", true), a(l).visible("mac") ? (t(), r(i, { key: "mac", prop: "mac", label: "MAC地址", "min-width": "60px", align: "center" }, { default: o((e) => [p("span", null, s(e.row.mac), 1)]), _: 1 })) : n("", true), a(l).visible("opcUrl") ? (t(), r(i, { key: "opcUrl", prop: "opcUrl", label: "工控机地址", "min-width": "60px", align: "center" }, { default: o((e) => [p("span", null, s(e.row.opcUrl), 1)]), _: 1 })) : n("", true), a(l).visible("online") ? (t(), r(i, { key: "online", prop: "online", align: "center", label: "链接状态", "min-width": "45px" }, { default: o((e) => [p("span", null, s(a(U).VL[e.row.online]), 1)]), _: 1 })) : n("", true), a(A)([...a(_).edit]) ? (t(), r(i, { key: 11, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: o((e) => [c(a(E), { showEdit: true, showDel: false, data: e.row }, null, 8, ["data"])]), _: 1 })) : n("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[y, a(d).loading]]), c(a(I)), c(a(V))]);
  };
} };
export {
  W as default
};
