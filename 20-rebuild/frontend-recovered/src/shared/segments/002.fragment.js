function Ho(e) {
  const o = Number(e).toString().split(".");
  return o.length === 2 ? o[1].length : 0;
}
function ve(e) {
  const o = {}, n = {}, c = {}, u = {}, r = Object.keys(e);
  e.ENUM = Object.assign({}, e), r.forEach((E) => {
    const y = e[E].V, b = e[E].L;
    o[E] = y, n[y] = b, c[y] = E, u[y] = e[E];
  }), e.KV = o, e.VL = n, e.VK = c, e.V = u, e.KEYS = r;
}
function CA(e) {
  const o = {};
  for (const n in e) o[e[n].V] = e[n];
  return ve(o), o;
}
function PA(e, o = true) {
  let n = [];
  for (const c in e.ENUM) n.push(e[c]);
  return o && (n = JSON.parse(JSON.stringify(n))), n;
}
function Js(e, o, n) {
  const c = [], u = Ae(e.ENUM) ? e : e.ENUM;
  for (const r in u) if (u[r].V & o) switch (n) {
    case "K":
    case "V":
    case "L":
      c.push(u[r][n]);
      break;
    default:
      c.push(u[r]);
      break;
  }
  return c;
}
function OA(e) {
  let o;
  return Array.isArray(e) ? o = e : typeof e == "object" && (o = Object.keys(e.VK)), Array.isArray(o) ? o.reduce((n, c) => n | c, 0) : 0;
}
function kA(e, o, n, c = "L", u = "V") {
  if (Ae(o) && Ae(e)) return;
  const r = [];
  return Object.keys(e).forEach((E) => {
    o.includes(e[E][u]) && r.push(e[E][c]);
  }), A(n) ? r.join(n) : r;
}
function Jlt(e, o, n, c = "L", u = "V") {
  return kA(e, lw(o), n, c, u);
}
function Xlt(e, o, n = "L", c = "V") {
  const u = Ae(e.ENUM) ? e : e.ENUM;
  let r = "";
  for (const E in u) if (console.log(E, u, o, n, c), u[E][c] & o) {
    r = u[E][n];
    break;
  }
  return r;
}
function DA(e, o, n, c, u, r = void 0) {
  return e.map((E) => {
    let y;
    return Object.keys(c).forEach((b, V) => {
      typeof c[b] == "object" && c[b][u] === E[o] && (y = c[b]);
    }), r !== void 0 && y && (E[n] = y[r]), E;
  });
}
const gn = { PROCESS: { L: "进行中", K: "PROCESS", V: 1, TAG: "primary" }, SUSPEND: { L: "已暂停", K: "SUSPEND", V: 2, TAG: "danger" }, COMPLETE: { L: "已完工", K: "COMPLETE", V: 4, TAG: "warning" }, SETTLED: { L: "已结算", K: "COMPLETE", V: 8, TAG: "success" } };
ve(gn);
const nt = { SERIAL_NUMBER_START: { L: "合同编号 项目名称", K: "SERIAL_NUMBER_START", V: 1 }, SERIAL_NUMBER_END: { L: "项目名称 合同编号", K: "SERIAL_NUMBER_END", V: 2 } };
ve(nt);
const $e = { STEEL: { L: "建筑钢结构", SL: "建钢", K: "STEEL", V: 1 }, BRIDGE: { L: "桥梁钢结构", SL: "桥梁", K: "BRIDGE", V: 2 }, ENCLOSURE: { L: "建筑围护结构", SL: "围护", K: "ENCLOSURE", V: 8 } };
ve($e);
const Gm = { MACHINING: { L: "加工承揽", K: "MACHINING", V: 1 }, INSTALLATION: { L: "项目承包", K: "INSTALLATION", V: 2 } };
ve(Gm);
const Qm = { STRUCTURE: { L: "结构", K: "STRUCTURE", V: 2 }, ENCLOSURE: { L: "围护", K: "ENCLOSURE", V: 4 }, AUXILIARY_MATERIAL: { L: "配套件", K: "AUXILIARY_MATERIAL", V: 8 }, BOX: { L: "分段制品", K: "BOX", V: 16 } };
ve(Qm);
const Zm = { STRUCTURE: { L: "结构", K: "STRUCTURE", V: 1 }, PROFILED_PLATE: { L: "压型彩板", K: "PROFILED_PLATE", V: 2 }, TRUSS_FLOOR_PLATE: { L: "桁架楼承板", K: "TRUSS_FLOOR_PLATE", V: 8 }, PRESSURE_BEARING_PLATE: { L: "压型楼承板", K: "PRESSURE_BEARING_PLATE", V: 16 }, SANDWICH_BOARD: { L: "夹芯板", K: "SANDWICH_BOARD", V: 4 } };
ve(Zm);
const Jm = { STRUCTURE: { L: "结构", K: "STRUCTURE", V: 1 } };
ve(Jm);
const Xi = { STRUCTURE: { L: "结构", K: "STRUCTURE", V: 1 }, PROFILED_PLATE: { L: "压型彩板", K: "PROFILED_PLATE", V: 2 }, TRUSS_FLOOR_PLATE: { L: "桁架楼承板", K: "TRUSS_FLOOR_PLATE", V: 8 }, PRESSURE_BEARING_PLATE: { L: "压型楼承板", K: "PRESSURE_BEARING_PLATE", V: 16 }, SANDWICH_BOARD: { L: "夹芯板", K: "SANDWICH_BOARD", V: 4 }, BENDING: { L: "折边件", K: "BENDING", V: 32 }, BRIDGE: { L: "箱体", K: "BRIDGE", V: 128 } };
ve(Xi);
const Xm = { STRUCTURE: { L: "结构配套件", K: "STRUCTURE", V: 2 }, ENCLOSURE: { L: "围护配套件", K: "ENCLOSURE", V: 4 } };
ve(Xm);
const xi = { MACHINING: { L: "加工承揽", K: "MACHINING", V: 1 }, INSTALLATION: { L: "项目承包", K: "INSTALLATION", V: 2 }, INSTALL: { L: "安装合同", K: "INSTALL", V: 4 } };
ve(xi);
const $m = { CONTRACT: { L: "承包合同", K: "CONTRACT", V: 1, T: "primary" }, REPLENISHMENT_CONTRACT: { L: "补充合同", K: "REPLENISHMENT_CONTRACT", V: 2, T: "info" }, PURCHASE_CONTRACT: { L: "采购合同", K: "PURCHASE_CONTRACT", V: 3, T: "success" }, SUB_CONTRACT: { L: "分包合同", K: "SUB_CONTRACT", V: 4, T: "warning" } };
ve($m);
const ep = { PRIVATE_ENTERPRISE: { L: "民企", K: "PRIVATE_ENTERPRISE", V: 1 }, STATE_OWNED_ENTERPRISE: { L: "国企", K: "STATE_OWNED_ENTERPRISE", V: 2 }, CENTRAL_ENTERPRISES: { L: "央企", K: "CENTRAL_ENTERPRISES", V: 3 }, STATE_OWNED_ENTERPRISE_LISTED_COMPANY: { L: "民企上市公司", K: "STATE_OWNED_ENTERPRISE_LISTED_COMPANY", V: 4 }, PRIVATE_ENTERPRISE_LISTED_COMPANY: { L: "国企上市公司", K: "PRIVATE_ENTERPRISE_LISTED_COMPANY", V: 5 }, CENTRAL_ENTERPRISES_LISTED_COMPANY: { L: "央企上市公司", K: "CENTRAL_ENTERPRISES_LISTED_COMPANY", V: 6 } };
ve(ep);
const tp = { PROPRIETOR_CONTRACT_OUT: { L: "业主直接发包", K: "PROPRIETOR_CONTRACT_OUT", V: 1 }, SPECIALIZED_SUBCONTRACT: { L: "专业分包", K: "SPECIALIZED_SUBCONTRACT", V: 2 }, GENERAL_CONTRACT: { L: "总承包", K: "GENERAL_CONTRACT", V: 3 } };
ve(tp);
const ip = { SALESMAN_WITH_MANAGER: { L: "销售员信息项目经理配合", K: "SALESMAN_WITH_MANAGER", V: 1 }, MANAGER_WITH_SALESMAN: { L: "项目经理信息销售员配合", K: "MANAGER_WITH_SALESMAN", V: 2 }, SALESMAN: { L: "销售员信息", K: "SALESMAN", V: 3 } };
ve(ip);
const ap = { SEPARATE: { L: "单独计价", K: "SEPARATE", V: 2 }, MERGER: { L: "合并计价", K: "MERGER", V: 4 } };
ve(ap);
const lp = { YES: { L: "是", SL: "含税", K: "YES", V: true }, NO: { L: "否", SL: "不含税", K: "NO", V: false } };
ve(lp);
const op = { YES: { L: "是", SL: "含税", K: "YES", V: 1 }, NO: { L: "否", SL: "不含税", K: "NO", V: 0 } };
ve(op);
const np = { THEORY: { L: "理计结算", SL: "理计", K: "THEORY", V: 1, COLOR: "#1682e6" }, OVERWEIGHT: { L: "磅计结算", SL: "磅计", K: "OVERWEIGHT", V: 2, COLOR: "#e64242" } };
ve(np);
const sp = { AUDITING: { L: "审核中", K: "AUDITING", V: 1, HIDE: true, TYPE: "primary" }, PASS: { L: "审核通过", K: "PASS", V: 2, TYPE: "success" }, REJECT: { L: "驳回", K: "REJECT", V: 4, TYPE: "danger" } };
ve(sp);
const rp = { AUDITING: { L: "待审核", K: "AUDITING", V: 1, HIDE: true, TYPE: "primary" }, PASS: { L: "审核通过", K: "PASS", V: 2, TYPE: "success" }, REJECT: { L: "驳回", K: "REJECT", V: 4, TYPE: "danger" } };
ve(rp);
