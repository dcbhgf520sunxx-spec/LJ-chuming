import { ref as v } from "vue";
import { ElNotification as ne } from "element-plus";
import { reactive as oe } from "vue";
import { provide as ie } from "vue";
import { watch as le } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as k } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as w } from "vue";
import { unref as t } from "vue";
import { withDirectives as V } from "vue";
import { createBlock as s } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as c } from "vue";
import { ElTableColumn as re } from "element-plus";
import { InfoFilled as se } from "@element-plus/icons-vue";
import { ElIcon as ce } from "element-plus";
import { ElTooltip as ue } from "element-plus";
import { ElTag as pe } from "element-plus";
import { ElSwitch as de } from "element-plus";
import { vLoading as me } from "element-plus";
import { u as fe, x as he, G as N, o as we, lX as ge, lY as D, l_ as P, P as ye } from "../../../../shared/runtime.js";
import { c as _e } from "../../../../modules/nestList-abbaa81d.js";
import { c as ve, g as M } from "../../../../modules/project-data-5e9d497a.js";
import { g as F } from "../../../../modules/machine-10301ee2.js";
import { s as be } from "../../../../modules/scheduling-2b0c95c3.js";
import ke from "./module/header.vue.js";
import xe from "../../template/steel-plate-list.vue.js";
import Ce from "../../template/detail.vue.js";
import { p as x } from "../../../../modules/cutting-457c256f.js";
import { g as Ie } from "../../../../modules/radan-controller-25ebed6e.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const Ne = { class: "app-container" }, Se = { class: "head-container" }, Te = { style: { display: "inline-block" } }, Le = { key: 0 }, je = { key: 1 }, Ee = { key: 2 }, Ve = { key: 0 }, $e = { __name: "index", props: { visible: { type: Boolean, required: true }, detailData: { type: Object } }, emits: ["update:visible", "colesHook"], setup(O, { emit: G }) {
  const S = v(), T = v(false), C = v({}), L = v(false), R = v(""), I = v({}), q = O, H = G;
  fe({ emit: H, props: q, field: "visible", closeHook: z, showHook: $ });
  function $() {
    U();
  }
  function z() {
    H("colesHook");
  }
  async function U(i, r) {
    console.log(i, r), i.switchLoading = true;
    try {
      const u = [i.id];
      console.log(u);
      let m = "";
      i.plateState === "5" ? m = await ve(u) : m = await be(u), ne({ title: "更改状态成功", message: m, type: "success" }), console.log(I.value, "11111111111");
      const g = await M({ mac: r.mac, projectId: r.projectId });
      g.content.forEach((f) => {
        f.plateState === "5" ? f.State = false : f.State = true;
      });
      for (var e = 0; e < g.content.length; e++) if (g.content[e].mac) {
        const f = await F(g.content[e].mac);
        g.content[e].machineType = f.machineType, g.content[e].factory = f.factory, g.content[e].workshopInf = f.workshopInf, g.content[e].productionLine = f.productionLine;
      }
      _.data[r.rowIndex].subList = g.content;
    } catch (u) {
      console.log(u);
    }
    i.switchLoading = false;
  }
  const K = { add: false, edit: false, del: false, download: false }, b = oe({ summary: {}, provinceList: [], loading: true });
  ie("projectInfo", b);
  const { crud: _, CRUD: Q, columns: d } = he({ title: "项目任务", sort: [], permission: { ...x }, optShow: { ...K }, crudApi: { ..._e }, hasPagination: true }, S);
  le((i) => {
    X(), _.toQuery();
  }, { deep: true }), Q.HOOK.handleRefresh = (i, r) => {
    r.data.content = r.data.content.map((e, u) => (e.subList = [], e.rowIndex = u, e));
  };
  async function X() {
    if (N(x.statistics)) {
      b.loading = true;
      try {
        const i = await Ie({ year: _.query.importTime }) || {};
        b.provinceList = i.provinceList, delete i.provinceList, b.summary = i;
      } catch (i) {
        console.log("获取项目汇总图表数据", i);
      } finally {
        b.loading = false;
      }
    }
  }
  async function Y(i, r) {
    console.log(i, r), I.value = i, i.loadingList = true;
    try {
      const u = await M({ projectId: I.value.projectId, mac: I.value.mac });
      u.content.forEach((m) => {
        m.plateState === "5" ? m.State = false : m.State = true;
      });
      for (var e = 0; e < u.content.length; e++) if (u.content[e].mac) {
        const m = await F(u.content[e].mac);
        u.content[e].machineType = m.machineType, u.content[e].factory = m.factory, u.content[e].workshopInf = m.workshopInf, u.content[e].productionLine = m.productionLine;
      }
      i.subList = u.content;
    } catch {
      console.log("请求接口数据失败");
    }
    i.loadingList = false;
  }
  function J(i) {
    C.value = i, R.value = i.mac, L.value = true;
  }
  function Z(i) {
    R.value = i.mac;
  }
  const { maxHeight: A } = we({ wrapperBox: ".contractRecord", paginate: true, extraHeight: 40 });
  async function ee(i) {
    C.value = i, T.value = true;
  }
  return (i, r) => {
    const e = re, u = se, m = ce, g = ue, f = pe, te = de, W = B("common-table"), ae = B("common-button"), j = me;
    return o(), k("div", Ne, [h("div", Se, [w(t(ke))]), V((o(), s(W, { ref_key: "tableRef", ref: S, data: t(_).data, "empty-text": t(_).emptyText, "max-height": t(A) - 50, style: { width: "100%" }, "row-key": "projectId", onExpandChange: Y, returnSourceData: "" }, { default: l(() => [w(e, { type: "expand" }, { default: l((a) => [V((o(), s(W, { ref_key: "tableRef", ref: S, data: a.row.subList, onChange: i.handleChange, isSingle: "", "row-key": "id", "max-height": t(A), showEmptySymbol: false, style: { width: "100%" }, border: "" }, { default: l(() => [w(e, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(d).visible("cutInstructionId") ? (o(), s(e, { "header-align": "center", key: "cutInstructionId", prop: "cutInstructionId", "show-overflow-tooltip": true, style: { width: "100%" }, label: "切割指令号", align: "center", "min-width": "100" }, { default: l((n) => [y(p(n.row.cutInstructionId), 1)]), _: 2 }, 1024)) : c("", true), t(d).visible("thick") ? (o(), s(e, { "header-align": "center", key: "thick", prop: "thick", "show-overflow-tooltip": true, style: { width: "100%" }, label: "钢板厚度", align: "center", "min-width": "60" }, { header: l(() => [w(g, { class: "item", effect: "dark", content: "点击钢板的厚度查看套料文件", placement: "right-start" }, { default: l(() => [h("div", Te, [r[2] || (r[2] = h("span", { style: { "margin-right": "3px" } }, "钢板厚度", -1)), w(m, null, { default: l(() => [w(u)]), _: 1 })])]), _: 1 })]), default: l((n) => [t(N)(t(x).detailResult) ? (o(), s(f, { key: 0, type: "primary", size: "default", onClick: (E) => J(n.row) }, { default: l(() => [y(p(n.row.thick), 1)]), _: 2 }, 1032, ["onClick"])) : c("", true)]), _: 2 }, 1024)) : c("", true), t(d).visible("material") ? (o(), s(e, { "header-align": "center", key: "material", prop: "material", "show-overflow-tooltip": true, style: { width: "100%" }, label: "材质", align: "center", "min-width": "60" }, { default: l((n) => [y(p(n.row.material), 1)]), _: 2 }, 1024)) : c("", true), t(d).visible("specification") ? (o(), s(e, { "header-align": "center", key: "specification", prop: "specification", "show-overflow-tooltip": true, style: { width: "100%" }, label: "规格", align: "center", "min-width": "60" }, { default: l((n) => [y(p(n.row.width) + " * " + p(n.row.length), 1)]), _: 2 }, 1024)) : c("", true), t(d).visible("num") ? (o(), s(e, { "header-align": "center", key: "num", prop: "num", "show-overflow-tooltip": true, style: { width: "100%" }, label: "数量", align: "center", "min-width": "60" }, { default: l(() => r[3] || (r[3] = [h("span", null, "1", -1)])), _: 1, __: [3] })) : c("", true), t(d).visible("plateState") ? (o(), s(e, { key: "plateState", prop: "plateState", align: "center", label: "完成状态", "min-width": "60px" }, { default: l((n) => [h("span", null, p(t(ge).VL[n.row.plateState]), 1)]), _: 2 }, 1024)) : c("", true), t(d).visible("machineType") ? (o(), s(e, { align: "center", key: "machineType", prop: "machineType", "show-overflow-tooltip": true, label: "切割方式", "min-width": "70" }, { default: l((n) => [n.row.mac && n.row.machineType === t(D).FLAME_CUTTING.V ? (o(), k("span", Le, "火焰切割设备")) : c("", true), n.row.mac && n.row.machineType === t(D).PLASMA_CUTTING.V ? (o(), k("span", je, "等离子切割设备")) : c("", true), n.row.mac && n.row.machineType === t(D).LASER_CUTTING.V ? (o(), k("span", Ee, "激光切割设备")) : c("", true)]), _: 2 }, 1024)) : c("", true), t(d).visible("name") ? (o(), s(e, { align: "center", key: "name", prop: "name", "show-overflow-tooltip": true, label: "所属产线", "min-width": "100" }, { default: l((n) => [n.row.factory ? (o(), k("span", Ve, p(n.row.factory) + ">" + p(n.row.workshopInf) + ">" + p(n.row.productionLine), 1)) : c("", true)]), _: 2 }, 1024)) : c("", true), t(N)(t(x).pauseCutting) ? (o(), s(e, { key: 8, align: "center", "show-overflow-tooltip": true, label: "暂停切割", "min-width": "70" }, { default: l((n) => [V(w(te, { "active-color": "#409EFF", "inactive-color": "#F56C6C", modelValue: n.row.State, "onUpdate:modelValue": (E) => n.row.State = E, onChange: (E) => U(n.row, a.row), disabled: !(n.row.plateState === "2" || n.row.plateState === "5") }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange", "disabled"]), [[j, n.row.switchLoading]])]), _: 2 }, 1024)) : c("", true)]), _: 2 }, 1032, ["data", "onChange", "max-height"])), [[j, a.row.loadingList]])]), _: 1 }), w(e, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(d).visible("projectName") ? (o(), s(e, { key: "projectName", prop: "projectName", "show-overflow-tooltip": true, label: "所属项目", "header-align": "center", "min-width": "130px" }, { default: l((a) => [h("span", null, p(a.row.projectNumber) + "-" + p(a.row.projectName), 1)]), _: 1 })) : c("", true), t(d).visible("plateNum") ? (o(), s(e, { align: "center", key: "plateNum", prop: "plateNum", label: "钢板总数", "min-width": "100px" }, { default: l((a) => [h("span", null, p(a.row.plateNum), 1)]), _: 1 })) : c("", true), t(d).visible("plateWeight") ? (o(), s(e, { align: "center", key: "plateWeight", prop: "plateWeight", label: "钢板总重", "min-width": "100px" }, { default: l((a) => [h("span", null, p(a.row.plateWeight), 1)]), _: 1 })) : c("", true), t(d).visible("partNum") ? (o(), s(e, { align: "center", key: "partNum", prop: "partNum", label: "零件数", "min-width": "100px" }, { default: l((a) => [h("span", null, p(a.row.partNum), 1)]), _: 1 })) : c("", true), t(d).visible("partWeight") ? (o(), s(e, { align: "center", key: "partWeight", prop: "partWeight", label: "零件重", "min-width": "100px" }, { default: l((a) => [h("span", null, p(a.row.partWeight), 1)]), _: 1 })) : c("", true), t(d).visible("cuttingNum") ? (o(), s(e, { prop: "cuttingNum", key: "cuttingNum", align: "center", label: "已切割", "min-width": "100px" }, { default: l((a) => [h("span", null, p(a.row.cuttingNum), 1)]), _: 1 })) : c("", true), t(d).visible("noCuttingNum") ? (o(), s(e, { prop: "noCuttingNum", key: "noCuttingNum", align: "center", label: "未切割", "min-width": "100px" }, { default: l((a) => [h("span", null, p(a.row.plateNum - a.row.cuttingNum), 1)]), _: 1 })) : c("", true), t(N)(t(x).detail) ? (o(), s(e, { key: 7, align: "center", label: "查看切割状态", "min-width": "80px" }, { default: l((a) => [w(ae, { icon: "el-icon-view", type: "primary", size: "default", onClick: (n) => ee(a.row) }, null, 8, ["onClick"])]), _: 1 })) : c("", true), t(d).visible("cutState") ? (o(), s(e, { align: "center", key: "cutState", prop: "cutState", "show-overflow-tooltip": true, label: "状态", "min-width": "100px" }, { default: l((a) => [h("span", null, [a.row.cutState === t(P).NOT_Cutting_up.V ? (o(), s(f, { key: 0, style: { width: "100%" }, effect: "plain", type: "danger" }, { default: l(() => r[4] || (r[4] = [y(" 未切割 ")])), _: 1, __: [4] })) : a.row.cutState && a.row.cutState === t(P).PARTIAL_Cutting_up.V ? (o(), s(f, { key: 1, style: { width: "100%" }, effect: "plain", type: "warning" }, { default: l(() => r[5] || (r[5] = [y(" 部分切割 ")])), _: 1, __: [5] })) : a.row.cutState && a.row.cutState === t(P).Cutting_up.V ? (o(), s(f, { key: 2, style: { width: "100%" }, effect: "plain", type: "success" }, { default: l(() => r[6] || (r[6] = [y(" 切割结束 ")])), _: 1, __: [6] })) : c("", true)])]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[j, t(_).loading]]), w(t(ye)), w(xe, { "detail-data": C.value, visible: T.value, "onUpdate:visible": r[0] || (r[0] = (a) => T.value = a) }, null, 8, ["detail-data", "visible"]), w(Ce, { onChange: Z, "detail-data": C.value, visible: L.value, "onUpdate:visible": r[1] || (r[1] = (a) => L.value = a) }, null, 8, ["detail-data", "visible"])]);
  };
} };
export {
  $e as default
};
