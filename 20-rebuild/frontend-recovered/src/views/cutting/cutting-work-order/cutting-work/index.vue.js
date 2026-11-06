import { ref as v } from "vue";
import { resolveComponent as q } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as S } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as c } from "vue";
import { unref as l } from "vue";
import { withDirectives as F } from "vue";
import { createBlock as u } from "vue";
import { withCtx as a } from "vue";
import { createTextVNode as p } from "vue";
import { toDisplayString as w } from "vue";
import { createCommentVNode as s } from "vue";
import { withModifiers as T } from "vue";
import { ElMessage as U } from "element-plus";
import { ElNotification as Ce } from "element-plus";
import { ElTableColumn as Le } from "element-plus";
import { ElPopover as Se } from "element-plus";
import { ElTag as Te } from "element-plus";
import { vLoading as Ne } from "element-plus";
import { c as Ie } from "../../../../modules/nestList-abbaa81d.js";
import { e as Q } from "../../../../modules/project-data-5e9d497a.js";
import { g as K, s as Ee, a as Re, r as Ue } from "../../../../modules/machine-10301ee2.js";
import { u as De, x as Pe, o as je, lX as Ve, lY as D, G as x, lZ as P, P as He } from "../../../../shared/runtime.js";
import $e from "./module/header.vue.js";
import ze from "../../template/steel-plate-list.vue.js";
import Ae from "./module/task-scheduling/index.vue.js";
import { b as h } from "../../../../modules/cutting-457c256f.js";
import We from "../../template/detail.vue.js";
import "./module/machie/index.vue.js";
import "./module/preview/index.vue.js";
const Me = { class: "app-container" }, Be = { class: "head-container" }, Ge = { key: 0 }, Oe = { key: 1 }, qe = { key: 2 }, Fe = { style: { "text-align": "right", margin: "0" } }, Qe = { style: { "text-align": "right", margin: "0" } }, Ke = { style: { "text-align": "right", margin: "0" } }, st = { __name: "index", props: { visible: { type: Boolean, required: true }, detailData: { type: Object } }, emits: ["update:visible"], setup(X, { emit: Y }) {
  const j = X, V = Y;
  De({ emit: V, props: j, field: "visible", closeHook: J, showHook: Z });
  function Z() {
    j.detailData && _();
  }
  function J() {
    V("colesHook"), _();
  }
  const N = v(), H = v(false), C = v([]), ee = v(), L = v([]), I = v(false), te = v(false), $ = v(false), z = v(false), k = v({}), ne = { add: false, edit: false, del: false, download: false }, { crud: b, CRUD: ae, columns: g } = Pe({ title: "切割工单", sort: [], permission: { ...h }, optShow: { ...ne }, crudApi: { ...Ie }, hasPagination: true }, N);
  ae.HOOK.handleRefresh = (t, e) => {
    e.data.content = e.data.content.map((i, d) => (i.subList = [], i.rowIndex = d, i));
  };
  async function ie(t, e) {
    if (!x(h.detail)) return false;
    console.log(t, e, "expandChange"), k.value = t, t.loadingList = true;
    try {
      const d = await Q.get({ projectId: k.value.projectId, mac: k.value.mac });
      console.log("data", d);
      for (var i = 0; i < d.content.length; i++) if (console.log(d.content[i].mac), d.content[i].mac !== null) {
        const y = await K(d.content[i].mac);
        d.content[i].machineType = y.machineType;
      }
      t.subList = d.content;
    } catch {
      console.log("请求接口数据失败");
    }
    t.loadingList = false;
  }
  async function _() {
    try {
      const { content: e } = await Q.get({ projectId: k.value.projectId, mac: k.value.mac });
      console.log("content", e);
      for (var t = 0; t < e.length; t++) if (console.log(e[t].mac), e[t].mac !== null) {
        const i = await K(e[t].mac);
        e[t].machineType = i.machineType;
      }
      b.data[k.value.rowIndex].subList = e;
    } catch (e) {
      console.log("钢板清单页面接口报错", e);
    }
  }
  async function le(t) {
    try {
      const e = [];
      e.push(t.id);
      const i = await Ee(e);
      U({ message: i, type: "success" });
      const d = C.value.find((y) => y.id === k.value.projectId);
      C.value.push(d), _(), b.toQuery();
    } catch {
      console.log("请求下发任务的接口失败");
    }
    t.taskLoading = false;
  }
  function A(t) {
    te.value = false;
  }
  function W(t) {
    $.value = false;
  }
  function M(t) {
    z.value = false;
  }
  function oe() {
    setTimeout(() => {
      document.addEventListener("click", A, { passive: false });
    }, 0);
  }
  function re() {
    document.removeEventListener("click", A);
  }
  function se() {
    setTimeout(() => {
      document.addEventListener("click", W, { passive: false });
    }, 0);
  }
  function ue() {
    document.removeEventListener("click", W);
  }
  function de() {
    setTimeout(() => {
      document.addEventListener("click", M, { passive: false });
    }, 0);
  }
  function ce() {
    document.removeEventListener("click", M);
  }
  function pe(t) {
    t.taskLoading = true;
  }
  function me(t) {
    t.cleanLoading = true;
  }
  function fe(t) {
    t.resetLoading = true;
  }
  function ge(t) {
    t.taskLoading = false;
  }
  function we(t) {
    t.cleanLoading = false;
  }
  function ve(t) {
    t.resetLoading = false;
  }
  async function ye(t) {
    try {
      const e = [];
      e.push(t.id);
      const i = await Re({ mac: t.mac }, e);
      U({ type: "error", message: i }), _();
    } catch {
      console.log("请求清除任务的接口数据失败");
    }
    $.value = false;
  }
  async function ke(t) {
    try {
      const e = [];
      e.push(t.id);
      const i = await Ue(e);
      U({ type: "warning", message: i });
      const d = C.value.find((y) => y.id === k.value.projectId);
      C.value.push(d), _(), b.toQuery();
    } catch {
      console.log("请求重置任务的接口失败");
    }
    z.value = false;
  }
  function he(t) {
    L.value = t, I.value = true;
  }
  function be(t) {
    ee.value = t.id;
  }
  const { maxHeight: B } = je({ wrapperBox: ".contractRecord", paginate: true, extraHeight: 40 }), E = v(false);
  function _e(t) {
    t.reportUrl !== null ? window.location.href = t.reportUrl : Ce({ title: "下载失败", message: "暂无套料成果 ", type: "error" });
  }
  function xe(t) {
    L.value = t, E.value = true;
  }
  return (t, e) => {
    const i = Le, d = q("common-button"), y = Se, G = q("common-table"), R = Te, O = Ne;
    return r(), S("div", Me, [m("div", Be, [c(l($e))]), F((r(), u(G, { ref_key: "tableRef", ref: N, data: l(b).data, "empty-text": l(b).emptyText, "max-height": l(B) - 50, style: { width: "100%" }, "row-key": "projectId", onExpandChange: ie, "expand-row-keys": C.value, returnSourceData: "" }, { default: a(() => [c(i, { type: "expand" }, { default: a((o) => [F((r(), u(G, { ref_key: "tableRef", ref: N, data: o.row.subList, "row-key": "id", "max-height": l(B), style: { width: "1000%" }, border: "" }, { default: a(() => [c(i, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), l(g).visible("cutInstructionId") ? (r(), u(i, { "header-align": "center", key: "cutInstructionId", prop: "cutInstructionId", "show-overflow-tooltip": true, style: { width: "100%" }, label: "切割指令号", align: "center", "min-width": "60" }, { default: a((n) => [p(w(n.row.cutInstructionId), 1)]), _: 2 }, 1024)) : s("", true), l(g).visible("thick") ? (r(), u(i, { "header-align": "center", key: "thick", prop: "thick", "show-overflow-tooltip": true, style: { width: "100%" }, label: "钢板厚度", align: "center", "min-width": "60" }, { default: a((n) => [p(w(n.row.thick), 1)]), _: 2 }, 1024)) : s("", true), l(g).visible("material") ? (r(), u(i, { "header-align": "center", key: "material", prop: "material", "show-overflow-tooltip": true, style: { width: "100%" }, label: "材质", align: "center", "min-width": "60" }, { default: a((n) => [p(w(n.row.material), 1)]), _: 2 }, 1024)) : s("", true), l(g).visible("specification") ? (r(), u(i, { "header-align": "center", key: "specification", prop: "specification", "show-overflow-tooltip": true, style: { width: "100%" }, label: "规格", align: "center", "min-width": "60" }, { default: a((n) => [p(w(n.row.width) + " * " + w(n.row.length), 1)]), _: 2 }, 1024)) : s("", true), l(g).visible("num") ? (r(), u(i, { "header-align": "center", key: "num", prop: "num", "show-overflow-tooltip": true, style: { width: "100%" }, label: "数量", align: "center", "min-width": "60" }, { default: a(() => e[3] || (e[3] = [m("span", null, "1", -1)])), _: 1, __: [3] })) : s("", true), l(g).visible("plateState") ? (r(), u(i, { align: "center", key: "plateState", prop: "plateState", label: "状态", "min-width": "60px" }, { default: a((n) => [m("span", null, w(l(Ve).VL[n.row.plateState]), 1)]), _: 2 }, 1024)) : s("", true), c(i, { align: "center", "show-overflow-tooltip": true, label: "套料成果", "min-width": "70" }, { default: a((n) => [c(d, { type: "success", size: "default", onClick: (f) => he(n.row) }, { default: a(() => e[4] || (e[4] = [p("查看")])), _: 2, __: [4] }, 1032, ["onClick"])]), _: 2 }, 1024), l(g).visible("machineType") ? (r(), u(i, { align: "center", key: "machineType", prop: "machineType", "show-overflow-tooltip": true, label: "切割方式", "min-width": "70" }, { default: a((n) => [n.row.mac && n.row.machineType === l(D).FLAME_CUTTING.V ? (r(), S("span", Ge, "火焰切割设备")) : s("", true), n.row.mac && n.row.machineType === l(D).PLASMA_CUTTING.V ? (r(), S("span", Oe, "等离子切割设备")) : s("", true), n.row.mac && n.row.machineType === l(D).LASER_CUTTING.V ? (r(), S("span", qe, "激光切割设备")) : s("", true)]), _: 2 }, 1024)) : s("", true), c(i, { fixed: "right", align: "center", label: "排产操作", "min-width": "90px" }, { default: a((n) => [n.row.plateState === "0" && l(x)(l(h).Production) ? (r(), u(d, { key: 0, onClick: T((f) => xe(n.row), ["stop"]), type: "success", size: "default" }, { default: a(() => e[5] || (e[5] = [p("任务排产")])), _: 2, __: [5] }, 1032, ["onClick"])) : s("", true), n.row.plateState === "1" ? (r(), u(y, { key: 1, visible: n.row.taskLoading, "onUpdate:visible": (f) => n.row.taskLoading = f, placement: "top", width: "180", trigger: "manual", onShow: oe, onHide: re }, { reference: a(() => [l(x)(l(h).taskLoading) ? (r(), u(d, { key: 0, type: "warning", size: "default", onClick: T((f) => pe(n.row), ["stop"]) }, { default: a(() => e[8] || (e[8] = [p(" 任务下发 ")])), _: 2, __: [8] }, 1032, ["onClick"])) : s("", true)]), default: a(() => [e[9] || (e[9] = m("p", null, "选择任务下发操作，确认任务下发？", -1)), m("div", Fe, [c(d, { size: "default", link: "", type: "primary", onClick: (f) => ge(n.row) }, { default: a(() => e[6] || (e[6] = [p("取消")])), _: 2, __: [6] }, 1032, ["onClick"]), c(d, { type: "primary", size: "default", onClick: (f) => le(n.row) }, { default: a(() => e[7] || (e[7] = [p("确定")])), _: 2, __: [7] }, 1032, ["onClick"])])]), _: 2, __: [9] }, 1032, ["visible", "onUpdate:visible"])) : s("", true), n.row.plateState === "1" ? (r(), u(y, { key: 2, visible: n.row.cleanLoading, "onUpdate:visible": (f) => n.row.cleanLoading = f, placement: "top", width: "180", trigger: "manual", onShow: se, onHide: ue }, { reference: a(() => [l(x)(l(h).cleanLoading) ? (r(), u(d, { key: 0, onClick: T((f) => me(n.row), ["stop"]), type: "danger", size: "default" }, { default: a(() => e[12] || (e[12] = [p("任务清除")])), _: 2, __: [12] }, 1032, ["onClick"])) : s("", true)]), default: a(() => [e[13] || (e[13] = m("p", null, "选择清除任务操作，确认清除任务？", -1)), m("div", Qe, [c(d, { size: "default", link: "", type: "primary", onClick: (f) => we(n.row) }, { default: a(() => e[10] || (e[10] = [p("取消")])), _: 2, __: [10] }, 1032, ["onClick"]), c(d, { type: "primary", size: "default", onClick: (f) => ye(n.row) }, { default: a(() => e[11] || (e[11] = [p("确定")])), _: 2, __: [11] }, 1032, ["onClick"])])]), _: 2, __: [13] }, 1032, ["visible", "onUpdate:visible"])) : s("", true), n.row.plateState === "2" ? (r(), u(y, { key: 3, visible: n.row.resetLoading, "onUpdate:visible": (f) => n.row.resetLoading = f, placement: "top", width: "180", trigger: "manual", onShow: de, onHide: ce }, { reference: a(() => [l(x)(l(h).resetLoading) ? (r(), u(d, { key: 0, onClick: T((f) => fe(n.row), ["stop"]), type: "primary", size: "default" }, { default: a(() => e[16] || (e[16] = [p("任务重置")])), _: 2, __: [16] }, 1032, ["onClick"])) : s("", true)]), default: a(() => [e[17] || (e[17] = m("p", null, "选择重置任务操作，确认重置任务？", -1)), m("div", Ke, [c(d, { size: "default", link: "", type: "primary", onClick: (f) => ve(n.row) }, { default: a(() => e[14] || (e[14] = [p("取消")])), _: 2, __: [14] }, 1032, ["onClick"]), c(d, { type: "primary", size: "default", onClick: (f) => ke(n.row) }, { default: a(() => e[15] || (e[15] = [p("确定")])), _: 2, __: [15] }, 1032, ["onClick"])])]), _: 2, __: [17] }, 1032, ["visible", "onUpdate:visible"])) : s("", true)]), _: 2 }, 1024)]), _: 2 }, 1032, ["data", "max-height"])), [[O, o.row.loadingList]])]), _: 1 }), c(i, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), l(g).visible("projectName") ? (r(), u(i, { key: "projectName", prop: "projectName", "show-overflow-tooltip": true, label: "所属项目", "header-align": "center", "min-width": "130px" }, { default: a((o) => [m("span", null, w(o.row.projectNumber) + "-" + w(o.row.projectName), 1)]), _: 1 })) : s("", true), l(g).visible("plateNum") ? (r(), u(i, { align: "center", key: "plateNum", prop: "plateNum", label: "钢板总数", "min-width": "100px" }, { default: a((o) => [m("span", null, w(o.row.plateNum), 1)]), _: 1 })) : s("", true), l(g).visible("plateWeight") ? (r(), u(i, { align: "center", key: "plateWeight", prop: "plateWeight", label: "钢板总重", "min-width": "100px" }, { default: a((o) => [m("span", null, w(o.row.plateWeight), 1)]), _: 1 })) : s("", true), l(g).visible("partNum") ? (r(), u(i, { align: "center", key: "partNum", prop: "partNum", label: "零件数", "min-width": "100px" }, { default: a((o) => [m("span", null, w(o.row.partNum), 1)]), _: 1 })) : s("", true), l(g).visible("partWeight") ? (r(), u(i, { align: "center", key: "partWeight", prop: "partWeight", label: "零件重", "min-width": "100px" }, { default: a((o) => [m("span", null, w(o.row.partWeight), 1)]), _: 1 })) : s("", true), l(g).visible("distributionNum") ? (r(), u(i, { align: "center", key: "distributionNum", prop: "distributionNum", label: "已排产", "min-width": "100px" }, { default: a((o) => [m("span", null, w(o.row.distributionNum), 1)]), _: 1 })) : s("", true), l(g).visible("distribution") ? (r(), u(i, { align: "center", key: "distribution", prop: "distribution", label: "未排产", "min-width": "100px" }, { default: a((o) => [m("span", null, w(o.row.plateNum - o.row.distributionNum), 1)]), _: 1 })) : s("", true), l(x)(l(h).download) ? (r(), u(i, { key: 7, align: "center", label: "套料成果", "min-width": "80px" }, { default: a((o) => [c(d, { disabled: o.row.reportUrl === null, icon: "el-icon-download", onClick: (n) => _e(o.row), type: "warning", size: "default" }, null, 8, ["disabled", "onClick"])]), _: 1 })) : s("", true), l(g).visible("nestingState") ? (r(), u(i, { align: "center", key: "nestingState", prop: "nestingState", "show-overflow-tooltip": true, label: "状态", "min-width": "100px" }, { default: a((o) => [m("span", null, [o.row.nestingState === l(P).NOT_Scheduling_up.V ? (r(), u(R, { key: 0, style: { width: "100%" }, effect: "plain", type: "danger" }, { default: a(() => e[18] || (e[18] = [p(" 未排产 ")])), _: 1, __: [18] })) : s("", true), o.row.nestingState && o.row.nestingState === l(P).PARTIAL_Scheduling_up.V ? (r(), u(R, { key: 1, style: { width: "100%" }, effect: "plain", type: "warning" }, { default: a(() => e[19] || (e[19] = [p(" 部分排产 ")])), _: 1, __: [19] })) : s("", true), o.row.nestingState && o.row.nestingState === l(P).Scheduling_up.V ? (r(), u(R, { key: 2, style: { width: "100%" }, effect: "plain", type: "success" }, { default: a(() => e[20] || (e[20] = [p(" 排产结束 ")])), _: 1, __: [20] })) : s("", true)])]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "expand-row-keys"])), [[O, l(b).loading]]), c(l(He)), c(ze, { "detail-data": L.value, visible: H.value, "onUpdate:visible": e[0] || (e[0] = (o) => H.value = o) }, null, 8, ["detail-data", "visible"]), c(l(Ae), { "detail-data": L.value, visible: E.value, "onUpdate:visible": e[1] || (e[1] = (o) => E.value = o), onSuccess: _ }, null, 8, ["detail-data", "visible"]), c(We, { onChange: be, "detail-data": L.value, visible: I.value, "onUpdate:visible": e[2] || (e[2] = (o) => I.value = o) }, null, 8, ["detail-data", "visible"])]);
  };
} };
export {
  st as default
};
