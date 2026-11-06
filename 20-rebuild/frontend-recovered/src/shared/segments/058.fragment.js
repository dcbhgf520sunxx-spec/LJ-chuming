function BEt(e, o) {
  if (!o) return;
  const n = JSON.parse(JSON.stringify(e)), c = new Map(n.map((u) => [u.key, u]));
  if (Object.keys(o).length) for (const [u, r] of Object.entries(o)) c.has(u) && (c.get(u).value = r);
  return Array.from(c.values());
}
function Rpe(e, o = null, n = null) {
  if (!e) return;
  const c = e.filter((r) => r.verify), u = {};
  return c.forEach((r) => {
    u[r.key] = [{ required: true, message: r.label + "不能为空", trigger: ["change", "blur"] }];
  }), o && (u[o] = [{ required: true, message: n, trigger: ["change", "blur"] }]), u;
}
function HEt(e, o, n = () => ({}), c = true) {
  if (c) return (u, r = n) => {
    const E = e.findIndex((y) => y === u);
    if (E !== -1) {
      for (let y = E + 1; y < e.length; y++) e[y] in o && (o[e[y]] = null);
      r();
    }
  };
}
function qEt(e, o, n, c, u, r = () => ({})) {
  return parseFloat(e) > parseFloat(c) ? (o[n] = null, R8("warning", u), r()) : true;
}
function Mpe(e, o = {}) {
  const { decimalPlaces: n = 2, allowNegative: c = true, trimLeadingZeros: u = true } = o;
  let r = e;
  c ? r = r.replace(/^-?|-/g, (y, b) => b === 0 ? y : "") : r = r.replace(/-/g, ""), r = r.replace(/[^\d.-]/g, ""), u && (r = r.replace(/^(-)?0+(?=\d)/, "$1"));
  const E = new RegExp(`^(-)?(\\d+\\.?\\d{0,${n}}).*$`);
  return r = r.replace(E, "$1$2"), r;
}
function GEt(e, o = {}) {
  const { allowNegative: n = false, max: c = null, min: u = null, emptyToZero: r = false } = o;
  let E = String(e).replace(n ? /[^\d-]/g : /[^\d]/g, "");
  n && (E = E.replace(/^-?|-/g, (b, V) => V === 0 ? b : ""));
  let y = parseInt(E, 10);
  return isNaN(y) ? r ? "0" : "" : (u !== null && (y = Math.max(y, u)), c !== null && (y = Math.min(y, c)), y.toString());
}
const D8 = { __name: "detail-v2", props: { journalId: { type: [String, Number] } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = e, c = zV(), u = o, r = Z(false), E = Z(null), y = Ct({});
  async function b() {
    try {
      const h = await Epe.get(`/api/contract/audit/getAuditDetail/${n.journalId}`), T = h2([h]);
      Object.assign(y, T[0], { approvalFlag: c.ApprovalFlag }), await V(T[0]);
    } catch (h) {
      console.error("打开详情失败:getItemData", h);
    }
  }
  const V = (h) => {
    const { paymentEnumName: T, projectAttributeName: _ } = h;
    r.value = true, pt(() => {
      _ ? E.value.headerTitle = `${T}` : E.value.headerTitle = `${T} `;
    });
  }, { crud: M } = qi(), g = () => {
    Pm(y), r.value = false, M.detailVisible = false;
  }, S = () => {
    u("auditSuccess");
  };
  return Ce(() => M.detailVisible, (h) => {
    h && b();
  }, { immediate: true }), yi("tableItemData", y), (h, T) => (w(), U(M8, ii({ ref_key: "drawerRef", ref: E, visible: r.value, "onUpdate:visible": T[0] || (T[0] = (_) => r.value = _), "table-item-data": y }, l(c), { onClose: g, onUpdateList: S }), null, 16, ["visible", "table-item-data"]));
} }, Ape = Object.freeze(Object.defineProperty({ __proto__: null, default: D8 }, Symbol.toStringTag, { value: "Module" }));
function Npe(e) {
  return W({ module: "mes", url: "machine_part/nesting/getNeedMachinePartDetailList", method: "post", data: e });
}
function Lpe(e) {
  return W({ url: "/api/app/mes/building/semiAutoCutTask/task_order/process/detail", method: "get", params: { schedulingId: e } });
}
function Ipe(e) {
  return W({ url: "/api/app/mes/building/semiFinishProductTask/task_order/process/detail", method: "get", params: { schedulingId: e } });
}
function Cpe(e) {
  return W({ url: "/api/app/mes/building/AutoCutTask/getApproveRecordDetail", method: "get", params: { wmsApproveRecordId: e } });
}
function Ppe(e) {
  return W({ url: "/api/mes/building/machine_part/nesting/approvePart", method: "post", params: e });
}
function Ope(e) {
  return W({ url: "/api/mes/building/machine_part/nesting/approveAutoCut", method: "post", params: e });
}
function QEt(e) {
  return W({ module: "mes", url: "machine_part/scheduling/month/listTwo", method: "post", data: e });
}
function ZEt(e) {
  return W({ module: "mes", url: "machine_part/nesting/getTeamList", method: "get", params: e });
}
function JEt(e) {
  return W({ module: "mes", url: "machine_part/nesting/getMaterialList", method: "post", data: e });
}
function XEt(e) {
  return W({ module: "mes", url: "machine_part/nesting/getThickList", method: "post", data: e });
}
function $Et(e) {
  return W({ module: "mes", url: "machine_part/nesting/scheduling/sendToNesting", method: "post", data: e, responseType: "blob", cancelKey: false });
}
function eyt(e) {
  return W({ module: "mes", url: "machine_part/nesting/scheduling/saveMachinePartDirect", method: "post", data: e });
}
function tyt(e) {
  return W({ module: "mes", url: "machine_part/scheduling", method: "delete", data: e });
}
function iyt(e) {
  return W({ module: "mes", url: "machine_part/scheduling/record/page", method: "get", params: e });
}
function ayt(e) {
  return W({ module: "mes", url: `machine_part/scheduling/record/${e}`, method: "get" });
}
function lyt(e) {
  return W({ module: "mes", url: "machine_part/scheduling/nesting", method: "post", data: e });
}
function oyt(e) {
  return W({ module: "mes", url: "machine_part/nesting/getWorkMachinePartListFromNestingLocal", method: "get", params: e });
}
function nyt(e) {
  return W({ module: "mes", url: "machine_part/scheduling/task/list", method: "get", params: e });
}
function syt(e) {
  return W({ module: "mes", url: "machine_part/scheduling/check/drill", method: "post", cancelKey: false, data: e });
}
function ryt(e) {
  return W({ module: "mes", url: "machine_part/scheduling/check/drill-v2", method: "post", cancelKey: false, data: e });
}
function uyt(e) {
  return W({ module: "mes", url: "machine_part/nesting/getWorkTree", method: "post", data: e });
}
function cyt(e) {
  return W({ module: "mes", url: "machine_part/nesting/getJobInfoByJobId", method: "get", params: e });
}
function dyt(e) {
  return W({ module: "mes", url: "machine_part/nesting/getJobWorkShopInfo", method: "get", params: e });
}
function myt(e) {
  return W({ module: "mes", url: "machine_part/nesting/getJobMaterial", method: "get", params: e });
}
function pyt(e) {
  return W({ module: "mes", url: "nesting-result/job-steel-plate/scheduling", method: "post", data: e });
}
function hyt(e) {
  return W({ module: "mes", url: "machine_part/scheduling/un_production", method: "post", data: e });
}
function fyt(e) {
  return W({ module: "mes", url: "machine_part/scheduling/un_production", method: "put", data: e });
}
function gyt(e) {
  return W({ module: "mes", url: "machine_part/scheduling/un_production/page", method: "get", params: e });
}
function Eyt(e) {
  return W({ module: "mes", url: "machine_part/nesting/getWorkShopList", method: "get", params: e });
}
function yyt(e) {
  return W({ url: "/api/plan/drawing/struct/nestingUpload", method: "post", timeout: 6e6, headers: { "Content-Type": "multipart/form-data" }, data: e });
}
function Tyt(e) {
  return W({ url: "/api/plan/drawing/struct/nestingUpload", method: "post", timeout: 6e6, headers: { "Content-Type": "multipart/form-data" }, data: e, responseType: "blob" });
}
function _yt(e) {
  return W({ module: "plan", url: "drawing/struct/nestingUpdate", method: "put", timeout: 6e6, headers: { "Content-Type": "multipart/form-data" }, data: e });
}
function byt(e) {
  return W({ module: "plan", url: "drawing/struct/nestingUpdate", method: "put", timeout: 6e6, headers: { "Content-Type": "multipart/form-data" }, responseType: "blob", data: e });
}
function Vyt(e) {
  return W({ module: "mes", url: "machine_part/nesting/exportMachinePartList", method: "post", timeout: 6e6, responseType: "blob", data: e });
}
function wyt(e) {
  return W({ module: "mes", url: "machine_part/nesting/exportWorkMachinePartListFromNesting", method: "post", responseType: "blob", data: e, cancelKey: false });
}
function Syt(e) {
  return W({ module: "mes", url: "nesting-result/job-steel-plate/cutting-code-download", method: "get", responseType: "blob", params: e, cancelKey: false });
}
function vyt(e) {
  return W({ module: "mes", url: "machine_part/nesting/exportWorkMachinePartListFromNesting", method: "post", data: e, cancelKey: false });
}
function Ryt(e) {
  return W({ module: "mes", url: "machine_part/nesting/downloadPDF", method: "post", responseType: "blob", params: e });
}
function Myt(e) {
  return W({ module: "mes", url: "team/partCutConfigTeamList/cutType", method: "get", params: e, cancelKey: false });
}
function Ayt(e) {
  return W({ module: "mes", url: "machine_part/nesting/deleteMachinePartNestingJob", method: "delete", params: e });
}
function Nyt(e) {
  return W({ module: "mes", url: "machine_part/nesting/deleteMachinePartNestingJobList", method: "post", data: e });
}
function Lyt(e) {
  return W({ url: "api/wms/nesting-docking/steel-plate", method: "get", params: e });
}
function Iyt(e) {
  return W({ url: "/api/wms/nesting-docking/section-steel", method: "get", params: e });
}
